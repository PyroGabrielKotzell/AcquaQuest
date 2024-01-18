package com.sussy.acquaquest.logic;

import java.io.File;
import java.util.EnumMap;
import com.badlogic.gdx.graphics.Texture;

public class ResourceLoader {
    private static EnumMap<ResourceEnum, Texture> mapTexture = new EnumMap<>(ResourceEnum.class);
    
    private static EnumMap<ResourceEnum, Texture[]> mapAnimation = new EnumMap<ResourceEnum, Texture[]>(ResourceEnum.class);
    
    public static Texture getTexture(ResourceEnum index) {
        if(!mapTexture.containsKey(index)){
            switch (index) {
                case Bait:
                    mapTexture.put(index, new Texture("esca/esca.png"));
                    break;
                case String:
                    mapTexture.put(index, new Texture("esca/filo.png"));
                    break;
                case Fish:
                    mapTexture.put(index, new Texture("fish/fish/fish0.png"));
                    break;
                case PlayerFishing:
                    mapTexture.put(index, new Texture("player/fishing/frame3.png"));
                    break;
                default: return null;
            }
        }  
        return mapTexture.get(index);
    }

    public static Texture[] getAnimation(ResourceEnum index) {
        if(!mapTexture.containsKey(index)){
            switch (index) {
                case Jelly:
                    mapAnimation.put(index, animator("assets/jelly/"));
                    break;
                case Shark:
                    mapAnimation.put(index, animator("assets/shark/shark/"));
                    break;
                case SharkAttack:
                    mapAnimation.put(index, animator("assets/shark/attack/"));
                    break;
                case PlayerIdle:
                    mapAnimation.put(index, animator("assets/player/idle"));
                    break;
                case PlayerBait:
                    mapAnimation.put(index, animator("assets/player/bait"));
                    break;
                case Background:
                    mapAnimation.put(index, animator("assets/backgrounds/"));
                    break;
                case Menutxt:
                    mapAnimation.put(index, animator("assets/menuText/"));
                    break;
                case Numbers:
                    mapAnimation.put(index, animator("assets/numbers/"));
                    break;
                default: return null;
            }
        }  
        return mapAnimation.get(index);
    }

    public static Texture[] animator(String s){
        File[] fs = new File(s).listFiles();
        Texture[] t = new Texture[fs.length];
        for(int i = 0; i < fs.length; i++) t[i] = new Texture(s + "/" + fs[i].getName());
        return t;
    }
}
