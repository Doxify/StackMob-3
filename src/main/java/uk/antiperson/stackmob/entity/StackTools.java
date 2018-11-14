package uk.antiperson.stackmob.entity;

import org.bukkit.entity.Entity;
import uk.antiperson.stackmob.StackMob;
import uk.antiperson.stackmob.tools.extras.GlobalValues;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class StackTools {

    private static HashMap<UUID, Integer> currentEntities = new HashMap<>();

    public static boolean hasValidStackData(Entity entity){
        return hasValidData(entity) &&
                getSize(entity) >= 1;
    }

    public static boolean hasNotEnoughNear(Entity entity){
        return hasValidData(entity) &&
                getSize(entity) == GlobalValues.NOT_ENOUGH_NEAR;
    }

    public static boolean hasValidData(Entity entity){
        return currentEntities.containsKey(entity.getUniqueId());
    }

    public static boolean hasValidMetadata(Entity entity, String metaTag){
        return entity.hasMetadata(metaTag) &&
                entity.getMetadata(metaTag).size() != 0;
    }

    public static int getSize(Entity entity){
        return currentEntities.get(entity.getUniqueId());
    }

    public static void setSize(Entity entity, int newSize){
        currentEntities.put(entity.getUniqueId(), newSize);
    }

    public static void removeSize(Entity entity){
        currentEntities.remove(entity.getUniqueId());
        entity.setCustomName(null);
        entity.setCustomNameVisible(false);
    }

    public static HashMap<UUID, Integer> getEntries(){
        return currentEntities;
    }

}
