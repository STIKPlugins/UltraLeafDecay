package me.stokmenn.ultraleafdecay.listeners;

import me.stokmenn.ultraleafdecay.config.Config;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.type.Leaves;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.LeavesDecayEvent;

public class BlockBreakListener implements Listener {
    private static final BlockFace[] NEIGHBOURS = {
            BlockFace.NORTH, BlockFace.EAST, BlockFace.SOUTH,
            BlockFace.WEST, BlockFace.UP, BlockFace.DOWN
    };

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        final Block block = event.getBlock();
        if (isInvalidLeaf(block)) return;

        handleLeafDecay(block);
    }

    @EventHandler
    public void onLeavesDecay(LeavesDecayEvent event) {
        final Block block = event.getBlock();
        if (isInvalidLeaf(block)) return;

        handleLeafDecay(block);
    }

    private void handleLeafDecay(Block block) {
        for (BlockFace face : NEIGHBOURS) {
            final Block neighbour = block.getRelative(face);
            if (isInvalidLeaf(neighbour)) continue;

            neighbour.breakNaturally();
            handleLeafDecay(neighbour);
        }
    }

    private boolean isInvalidLeaf(Block block) {
        if (!(block.getBlockData() instanceof Leaves leaves)) return true;
        return leaves.isPersistent() || leaves.getDistance() < Config.maxLogDistance;
    }
}