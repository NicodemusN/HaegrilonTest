
package net.mcreator.haegrilontest.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.IWorld;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.Mirror;
import net.minecraft.util.Direction;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.StateContainer;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.BooleanProperty;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.BlockItem;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.FluidState;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.DirectionalBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.haegrilontest.itemgroup.HaegrilondecorativeItemGroup;
import net.mcreator.haegrilontest.HaegrilontestModElements;

import java.util.List;
import java.util.Collections;

@HaegrilontestModElements.ModElement.Tag
public class WindowframebottomBlock extends HaegrilontestModElements.ModElement {
	@ObjectHolder("haegrilontest:windowframebottom")
	public static final Block block = null;
	public WindowframebottomBlock(HaegrilontestModElements instance) {
		super(instance, 363);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(
				() -> new BlockItem(block, new Item.Properties().group(HaegrilondecorativeItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(block, RenderType.getCutout());
	}
	public static class CustomBlock extends Block implements IWaterLoggable {
		public static final DirectionProperty FACING = DirectionalBlock.FACING;
		public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
		public CustomBlock() {
			super(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1f, 10f).setLightLevel(s -> 0).notSolid()
					.setOpaque((bs, br, bp) -> false));
			this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH).with(WATERLOGGED, false));
			setRegistryName("windowframebottom");
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
							.or(makeCuboidShape(16, 0, 16, 0, 1, 0), makeCuboidShape(2, 0, 16, 0, 16, 14), makeCuboidShape(16, 0, 16, 14, 16, 14),
									makeCuboidShape(2, 0, 2, 0, 16, 0), makeCuboidShape(16, 0, 2, 14, 16, 0))
							.withOffset(offset.x, offset.y, offset.z);
				case NORTH :
					return VoxelShapes
							.or(makeCuboidShape(0, 0, 0, 16, 1, 16), makeCuboidShape(14, 0, 0, 16, 16, 2), makeCuboidShape(0, 0, 0, 2, 16, 2),
									makeCuboidShape(14, 0, 14, 16, 16, 16), makeCuboidShape(0, 0, 14, 2, 16, 16))
							.withOffset(offset.x, offset.y, offset.z);
				case EAST :
					return VoxelShapes
							.or(makeCuboidShape(16, 0, 0, 0, 1, 16), makeCuboidShape(16, 0, 14, 14, 16, 16), makeCuboidShape(16, 0, 0, 14, 16, 2),
									makeCuboidShape(2, 0, 14, 0, 16, 16), makeCuboidShape(2, 0, 0, 0, 16, 2))
							.withOffset(offset.x, offset.y, offset.z);
				case WEST :
					return VoxelShapes
							.or(makeCuboidShape(0, 0, 16, 16, 1, 0), makeCuboidShape(0, 0, 2, 2, 16, 0), makeCuboidShape(0, 0, 16, 2, 16, 14),
									makeCuboidShape(14, 0, 2, 16, 16, 0), makeCuboidShape(14, 0, 16, 16, 16, 14))
							.withOffset(offset.x, offset.y, offset.z);
				case UP :
					return VoxelShapes
							.or(makeCuboidShape(0, 16, 0, 16, 0, 1), makeCuboidShape(14, 16, 0, 16, 14, 16), makeCuboidShape(0, 16, 0, 2, 14, 16),
									makeCuboidShape(14, 2, 0, 16, 0, 16), makeCuboidShape(0, 2, 0, 2, 0, 16))
							.withOffset(offset.x, offset.y, offset.z);
				case DOWN :
					return VoxelShapes
							.or(makeCuboidShape(0, 0, 16, 16, 16, 15), makeCuboidShape(14, 0, 16, 16, 2, 0), makeCuboidShape(0, 0, 16, 2, 2, 0),
									makeCuboidShape(14, 14, 16, 16, 16, 0), makeCuboidShape(0, 14, 16, 2, 16, 0))
							.withOffset(offset.x, offset.y, offset.z);
			}
		}

		@Override
		protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
			builder.add(FACING, WATERLOGGED);
		}

		public BlockState rotate(BlockState state, Rotation rot) {
			return state.with(FACING, rot.rotate(state.get(FACING)));
		}

		public BlockState mirror(BlockState state, Mirror mirrorIn) {
			return state.rotate(mirrorIn.toRotation(state.get(FACING)));
		}

		@Override
		public BlockState getStateForPlacement(BlockItemUseContext context) {
			boolean flag = context.getWorld().getFluidState(context.getPos()).getFluid() == Fluids.WATER;;
			return this.getDefaultState().with(FACING, context.getNearestLookingDirection().getOpposite()).with(WATERLOGGED, flag);
		}

		@Override
		public FluidState getFluidState(BlockState state) {
			return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
		}

		@Override
		public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld world, BlockPos currentPos,
				BlockPos facingPos) {
			if (state.get(WATERLOGGED)) {
				world.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(world));
			}
			return super.updatePostPlacement(state, facing, facingState, world, currentPos, facingPos);
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
	}
}
