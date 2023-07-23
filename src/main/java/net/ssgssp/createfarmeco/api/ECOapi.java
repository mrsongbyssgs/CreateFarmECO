package net.ssgssp.createfarmeco.api;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import me.yic.xconomy.api.XConomyAPI;

import java.math.BigDecimal;
import java.util.Random;
import java.util.UUID;

public final class ECOapi {
    public static void MessageSender(Player playerA, int Max, int Min, String str1,boolean isPlayerOn) {
        XConomyAPI xcapi = new XConomyAPI();
        UUID uuid1 = playerA.getUniqueId();
        String playername = playerA.getName();
        String string2;
        if(isPlayerOn){
            string2 = str1.replace("PLAYER", playername);
        }
        else {
            string2 = str1;
        }
        int inside = (Max + Min) / 2;
        Random random = new Random();
        int random1 = random.nextInt(10) + 1;
        if (random1 <= 9) {
            int n1 = random.nextInt(inside - Min + 1) + Min;
            String strX = String.valueOf(n1);
            String stringN1 = string2.replace("VALUE", strX);
            xcapi.changePlayerBalance(uuid1,playername,new BigDecimal(n1),true);
            String stringA1 = xcapi.getPlayerData(uuid1).getBalance().toString();
            String stringB1 = stringN1.replace("SOON",stringA1);
            playerA.spigot().sendMessage(ChatMessageType.ACTION_BAR,new TextComponent(stringB1));
        } else {
            int n2 = random.nextInt(Max - inside + 1) + inside;
            String strY = String.valueOf(n2);
            String stringN2 = string2.replace("VALUE",strY);
            xcapi.changePlayerBalance(uuid1,playername,new BigDecimal(n2),true);
            String stringA2 = xcapi.getPlayerData(uuid1).getBalance().toString();
            String stringB2 = stringN2.replace("SOON",stringA2);
            playerA.spigot().sendMessage(ChatMessageType.ACTION_BAR,new TextComponent(stringB2));
        }


    }
}


