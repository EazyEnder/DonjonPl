package fr.eazyender.donjon.utils;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_14_R1.CraftServer;
import org.bukkit.craftbukkit.v1_14_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_14_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;

import net.minecraft.server.v1_14_R1.EntityPlayer;
import net.minecraft.server.v1_14_R1.MinecraftServer;
import net.minecraft.server.v1_14_R1.PacketPlayOutNamedEntitySpawn;
import net.minecraft.server.v1_14_R1.PacketPlayOutPlayerInfo;
import net.minecraft.server.v1_14_R1.PlayerConnection;
import net.minecraft.server.v1_14_R1.PlayerInteractManager;
import net.minecraft.server.v1_14_R1.WorldServer;

public class NPCManager {
	
	public void createNPC(Player player, String npcName) {
        Location location = player.getLocation();
        MinecraftServer nmsServer = ((CraftServer) Bukkit.getServer()).getServer();
        WorldServer nmsWorld = ((CraftWorld) player.getWorld()).getHandle();
        GameProfile gameProfile = new GameProfile(UUID.randomUUID(), "�e�l" + npcName);
        changeSkin(gameProfile);
        EntityPlayer npc = new EntityPlayer(nmsServer, nmsWorld, gameProfile, new PlayerInteractManager(nmsWorld));
        npc.setLocation(location.getX(), location.getY(), location.getZ(), player.getLocation().getYaw(), player.getLocation().getPitch());

        PlayerConnection connection = ((CraftPlayer) player).getHandle().playerConnection;
        connection.sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.ADD_PLAYER, npc));
        connection.sendPacket(new PacketPlayOutNamedEntitySpawn(npc));
        //connection.sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.REMOVE_PLAYER, npc));
    }

    private void changeSkin(GameProfile profile){
        String texture = "eyJ0aW1lc3RhbXAiOjE1MDA3NzQzMjI0NDcsInByb2ZpbGVJZCI6ImVjMDcxODI1NTZiNDQ0ZDM4ZTlhZjQ4YmY3NGJkZTgyIiwicHJvZmlsZU5hbWUiOiJEb2ciLCJzaWduYXR1cmVSZXF1aXJlZCI6dHJ1ZSwidGV4dHVyZXMiOnsiU0tJTiI6eyJ1cmwiOiJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlL2EzNzRmZDZkMTQ0OGZhMTMwZTkyNDlhZjE5OTAyMzg0NmI4ZmM4NzdmMTE3ZjNhYzFjNDM0MDNiYTdmZWYzIn0sIkNBUEUiOnsidXJsIjoiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS81YzNjYTdlZTJhNDk4ZjFiNWQyNThkNWZhOTI3ZTYzZTQzMzE0M2FkZDU1MzhjZjYzYjZhOWI3OGFlNzM1In19fQ==";
        String signature = "yGUZXhcV0C38oUjNOtdMy1VHxfcicR91lKIrtByr71m/WbXN3Wueou08q9lfKyB5nBSH5i4vBfIKMb1HNVCminDssT8XRYQ0ost1QqMG94Ycv3x/6gHILQ7ww2BII95Um9nt0G28hIxktSlOLYnOWKmlL6fG1yXuNeis9NYR0EpYjsVFEFQVXgAhlSQeTbvcv7c5mnXqfLmYfKJ2hmIT51nc2Adv/6lUd8DHAZMA4mGdCYsQnyhvLcYDLAZgYhT3Qcs4q/mTgtPLgweMAfoHqyqlC4yZaXVSie97J+Ij/OSR/2d/RVhsATL4MbsJy/KJ+/ayihmY0OnDJnkbDUmNcm7125/eZXSj8fcrh2B6BSKfzoWqApGMFmgy4u35GC15aUBzXJ93t/mBBs3J7YV0Asx9aheL6dpOhpluwiXgvzObtvIdwqAY+mUkHI+OMzHKQT+IwfZp6BTbMwA0NhjTdxMWKTtI/uIgsJir1ButuDxFdJlP+y5nFHSARVYHd3MwScHe4feHOjr9sCxLTwn5n+0FsAQyw243AWV+S3EnqtZ+zHQo8DAC6g0p5+gUDVCj9DvmDukHpM/Du5aBFgnX5Ewu4mzr9Uu1fHSD9weE3gkD7Jb3RDSpxeYyDnZk/OHj8lfMsPcWMrdP8Sr46XZVocVgLNyNjCQ14vo+CqcohFk=";
        profile.getProperties().put("textures", new Property("textures",texture,signature));

    }

}