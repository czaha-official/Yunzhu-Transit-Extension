package top.xfunny.mod.block;

import org.jetbrains.annotations.NotNull;
import org.mtr.mapping.holder.*;
import org.mtr.mapping.mapper.BlockEntityExtension;
import org.mtr.mapping.mapper.TextHelper;
import org.mtr.mapping.tool.HolderBase;
import org.mtr.mod.block.IBlock;
import top.xfunny.mod.BlockEntityTypes;
import top.xfunny.mod.block.base.LiftButtonsBase;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Supplier;

public class HitachiVIB15Button extends LiftButtonsBase {
    private final Supplier<BlockEntityType<?>> blockEntityType;

    public HitachiVIB15Button() {
        this(() -> BlockEntityTypes.HITACHI_VIB15_BUTTON.get());
    }

    public HitachiVIB15Button(Supplier<BlockEntityType<?>> blockEntityType) {
        super(true, true);
        this.blockEntityType = blockEntityType;
    }

    @Nonnull
    @Override
    public VoxelShape getOutlineShape2(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        final boolean single = !IBlock.getStatePropertySafe(world.getBlockState(pos), SINGLE);
        return IBlock.getVoxelShapeByDirection(single ? 6 : 6.75, 2.775, 0, single ? 10 : 9.25, 12.775, 0.45, IBlock.getStatePropertySafe(state, FACING));
    }

    @Nonnull
    @Override
    public BlockEntityExtension createBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new HitachiVIB15Button.BlockEntity(blockEntityType.get(), blockPos, blockState);
    }

    @Override
    public void addBlockProperties(List<HolderBase<?>> properties) {
        properties.add(FACING);
        properties.add(UNLOCKED);
        properties.add(SINGLE);
    }

    @Override
    public void addTooltips(@NotNull ItemStack stack, @Nullable BlockView world, List<MutableText> tooltip, @NotNull TooltipContext options) {
        tooltip.add(TextHelper.translatable("tooltip.hitachi_display_bx_scl_c5").formatted(TextFormatting.GRAY));
        tooltip.add(TextHelper.translatable("tooltip.hitachi_button_ml_mo").formatted(TextFormatting.GRAY));
    }

    public static class BlockEntity extends BlockEntityBase {
        public BlockEntity(BlockPos pos, BlockState state) {
            this(BlockEntityTypes.HITACHI_VIB15_BUTTON.get(), pos, state);
        }

        public BlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
            super(type, pos, state);
        }
    }

    public static class Antibacterial35BlockEntity extends BlockEntity {
        public Antibacterial35BlockEntity(BlockPos pos, BlockState state) {
            super(BlockEntityTypes.HITACHI_VIB15_BUTTON_ANTIBACTERIAL_35.get(), pos, state);
        }
    }

    public static class Stainless35BlockEntity extends BlockEntity {
        public Stainless35BlockEntity(BlockPos pos, BlockState state) {
            super(BlockEntityTypes.HITACHI_VIB15_BUTTON_STAINLESS_35.get(), pos, state);
        }
    }

    public static class Premium35BlockEntity extends BlockEntity {
        public Premium35BlockEntity(BlockPos pos, BlockState state) {
            super(BlockEntityTypes.HITACHI_VIB15_BUTTON_PREMIUM_35.get(), pos, state);
        }
    }

    public static class Clear50BlockEntity extends BlockEntity {
        public Clear50BlockEntity(BlockPos pos, BlockState state) {
            super(BlockEntityTypes.HITACHI_VIB15_BUTTON_CLEAR_50.get(), pos, state);
        }
    }

    public static class Clear35BlockEntity extends BlockEntity {
        public Clear35BlockEntity(BlockPos pos, BlockState state) {
            super(BlockEntityTypes.HITACHI_VIB15_BUTTON_CLEAR_35.get(), pos, state);
        }
    }

    public static class ClearSquare35BlockEntity extends BlockEntity {
        public ClearSquare35BlockEntity(BlockPos pos, BlockState state) {
            super(BlockEntityTypes.HITACHI_VIB15_BUTTON_CLEAR_SQUARE_35.get(), pos, state);
        }
    }

    public static class ClearStainless35BlockEntity extends BlockEntity {
        public ClearStainless35BlockEntity(BlockPos pos, BlockState state) {
            super(BlockEntityTypes.HITACHI_VIB15_BUTTON_CLEAR_STAINLESS_35.get(), pos, state);
        }
    }

    public static class ClearStainlessSquare35BlockEntity extends BlockEntity {
        public ClearStainlessSquare35BlockEntity(BlockPos pos, BlockState state) {
            super(BlockEntityTypes.HITACHI_VIB15_BUTTON_CLEAR_STAINLESS_SQUARE_35.get(), pos, state);
        }
    }
}
