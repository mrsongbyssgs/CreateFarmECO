package net.ssgssp.createfarmeco;


import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.Plugin;

import java.util.Objects;

public class BlkbreakEvListener implements Listener {
    Plugin plug1 =  CreateFarmECO.getPlugin(CreateFarmECO.class);
    @EventHandler
    public void BlkbreakEv(BlockBreakEvent bee) {
        plug1.reloadConfig();
        Player player1 = bee.getPlayer();
        String string1 = Objects.requireNonNull(plug1.getConfig().getString("words"));
        int max1 = plug1.getConfig().getInt("BlockbreakMax");
        int min1 = plug1.getConfig().getInt("BlockbreakMin");
        boolean bool1 = plug1.getConfig().getBoolean("isPlayerOn");
        Block block1 = bee.getBlock();
        if(bee.isDropItems()){
            if (block1.getType().name().toLowerCase().endsWith("ore")) {
                if (!(player1.getInventory().getItemInMainHand().containsEnchantment(Enchantment.SILK_TOUCH))) {
                    net.ssgssp.createfarmeco.api.ECOapi.MessageSender(player1, max1, min1, string1, bool1);
                }
            }
        }
    }
}
