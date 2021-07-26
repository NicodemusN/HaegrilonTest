
package net.mcreator.haegrilontest.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.common.PlantType;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.IWorldReader;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.loot.LootContext;
import net.minecraft.item.TallBlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.DoublePlantBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.haegrilontest.itemgroup.HaegrilonplantsItemGroup;
import net.mcreator.haegrilontest.HaegrilontestModElements;

import java.util.List;
import java.util.Collections;

@HaegrilontestModElements.ModElement.Tag
public class ReedBlock extends HaegrilontestModElements.ModElement {
	@ObjectHolder("haegrilontest:reed")
	public static final Block block = null;
	public ReedBlock(HaegrilontestModElements instance) {
		super(instance, 300);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustomFlower());
		elements.items.add(
				() -> new TallBlockItem(block, new Item.Properties().group(HaegrilonplantsItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(block, RenderType.getCutout());
	}
	public static class BlockCustomFlower extends DoublePlantBlock {
		public BlockCustomFlower() {
			super(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.PLANT).hardnessAndResistance(0f, 0f)
					.setLightLevel(s -> 0));
			setRegistryName("reed");
		}

		@Override
		public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
			return 60;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			if (state.get(BlockStateProperties.DOUBLE_BLOCK_HALF) != DoubleBlockHalf.LOWER)
				return Collections.emptyList();
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}

		@Override
		public boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
			Block block = state.getBlock();
			return (block == Blocks.DIRT.getDefaultState().getBlock() || block == Blocks.COARSE_DIRT.getDefaultState().getBlock()
					|| block == Blocks.PODZOL.getDefaultState().getBlock() || block == RiverpebblesBlock.block.getDefaultState().getBlock()
					|| block == Blocks.WATER.getDefaultState().getBlock() || block == Blocks.WATER.getDefaultState().getBlock());
		}

		@Override
		public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
			BlockPos blockpos = pos.down();
			BlockState blockstate = worldIn.getBlockState(blockpos);
			if (state.get(HALF) == DoubleBlockHalf.UPPER)
				return blockstate.isIn(this) && blockstate.get(HALF) == DoubleBlockHalf.LOWER;
			else
				return this.isValidGround(blockstate, worldIn, blockpos);
		}

		@Override
		public PlantType getPlantType(IBlockReader world, BlockPos pos) {
			return PlantType.WATER;
		}
	}
}
