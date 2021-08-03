
package net.mcreator.haegrilontest.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.Mirror;
import net.minecraft.util.Hand;
import net.minecraft.util.Direction;
import net.minecraft.util.ActionResultType;
import net.minecraft.state.StateContainer;
import net.minecraft.state.DirectionProperty;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.BlockItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.haegrilontest.procedures.FrisiisoldierguardOnBlockRightClickedProcedure;
import net.mcreator.haegrilontest.itemgroup.ProfessionsItemGroup;
import net.mcreator.haegrilontest.HaegrilontestModElements;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Collections;

@HaegrilontestModElements.ModElement.Tag
public class FrisiisoldierguardBlock extends HaegrilontestModElements.ModElement {
	@ObjectHolder("haegrilontest:frisiisoldierguard")
	public static final Block block = null;
	public FrisiisoldierguardBlock(HaegrilontestModElements instance) {
		super(instance, 463);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ProfessionsItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(block, RenderType.getCutout());
	}
	public static class CustomBlock extends Block {
		public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
		public CustomBlock() {
			super(Block.Properties.create(Material.MISCELLANEOUS).sound(SoundType.PLANT).hardnessAndResistance(1f, 10f).setLightLevel(s -> 0)
					.notSolid().setOpaque((bs, br, bp) -> false));
			this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
			setRegistryName("frisiisoldierguard");
		}

		@Override
		public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
			return true;
		}

		@Override
		public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
			Vector3d offset = state.getOffset(world, pos);
			switch ((Direction) state.get(FACING)) {
				case SOUTH :
				default :
					return VoxelShapes
							.or(makeCuboidShape(12, 0, 10, 4, 12, 6), makeCuboidShape(12, 24, 12, 4, 32, 4), makeCuboidShape(16, 12, 10, 0, 24, 6))
							.withOffset(offset.x, offset.y, offset.z);
				case NORTH :
					return VoxelShapes
							.or(makeCuboidShape(4, 0, 6, 12, 12, 10), makeCuboidShape(4, 24, 4, 12, 32, 12), makeCuboidShape(0, 12, 6, 16, 24, 10))
							.withOffset(offset.x, offset.y, offset.z);
				case EAST :
					return VoxelShapes
							.or(makeCuboidShape(10, 0, 4, 6, 12, 12), makeCuboidShape(12, 24, 4, 4, 32, 12), makeCuboidShape(10, 12, 0, 6, 24, 16))
							.withOffset(offset.x, offset.y, offset.z);
				case WEST :
					return VoxelShapes
							.or(makeCuboidShape(6, 0, 12, 10, 12, 4), makeCuboidShape(4, 24, 12, 12, 32, 4), makeCuboidShape(6, 12, 16, 10, 24, 0))
							.withOffset(offset.x, offset.y, offset.z);
			}
		}

		@Override
		protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
			builder.add(FACING);
		}

		public BlockState rotate(BlockState state, Rotation rot) {
			return state.with(FACING, rot.rotate(state.get(FACING)));
		}

		public BlockState mirror(BlockState state, Mirror mirrorIn) {
			return state.rotate(mirrorIn.toRotation(state.get(FACING)));
		}

		@Override
		public BlockState getStateForPlacement(BlockItemUseContext context) {
			;
			return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
		}

		@Override
		public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction direction, IPlantable plantable) {
			return true;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}

		@Override
		public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity entity, Hand hand,
				BlockRayTraceResult hit) {
			super.onBlockActivated(state, world, pos, entity, hand, hit);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			Direction direction = hit.getFace();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				FrisiisoldierguardOnBlockRightClickedProcedure.executeProcedure($_dependencies);
			}
			return ActionResultType.SUCCESS;
		}
	}
}
