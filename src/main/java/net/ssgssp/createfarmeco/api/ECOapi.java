package net.ssgssp.createfarmeco.api;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Random;

public final class ECOapi {
    public static void MessageSender(Player playerA, int Max, int Min, String str1) {
        String playername = playerA.getName();
        String string2 = str1.replace("PLAYER", playername);
        String stringA = "money give PLAYERX NNNN";
        String stringB = stringA.replace("PLAYERX", playername);
        int inside = (Max + Min) / 2;
        Random random = new Random();
        int random1 = random.nextInt(10) + 1;
        if (random1 <= 9) {
            int n1 = random.nextInt(inside - Min + 1) + Min;
            String strX = String.valueOf(n1);
            String strA = stringB.replace("NNNN", strX);
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), strA);
            String stringN1 = string2.replace("VALUE", strX);
            playerA.spigot().sendMessage(ChatMessageType.ACTION_BAR,new TextComponent(stringN1));
        } else {
            int n2 = random.nextInt(Max - inside + 1) + inside;
            String strY = String.valueOf(n2);
            String strB = stringB.replace("NNNN", strY);
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), strB);
            String stringN2 = string2.replace("VALUE",strY);
            playerA.spigot().sendMessage(ChatMessageType.ACTION_BAR,new TextComponent(stringN2));
        }


    }
}


