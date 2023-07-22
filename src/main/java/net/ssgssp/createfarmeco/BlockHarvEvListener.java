package net.ssgssp.createfarmeco;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerHarvestBlockEvent;
import org.bukkit.plugin.Plugin;

import java.util.Objects;

public class BlockHarvEvListener implements Listener {
    Plugin plug1 = CreateFarmECO.getPlugin(CreateFarmECO.class);
    @EventHandler
    public void BlkHarvEv(PlayerHarvestBlockEvent hbe){
        plug1.reloadConfig();
        Player player1 = hbe.getPlayer();
        String string1 = Objects.requireNonNull(plug1.getConfig().getString("words"));
        int max1 = plug1.getConfig().getInt("HvMax");
        int min1 = plug1.getConfig().getInt("HvMin");
        net.ssgssp.createfarmeco.api.ECOapi.MessageSender(player1,max1,min1,string1);
    }
}
