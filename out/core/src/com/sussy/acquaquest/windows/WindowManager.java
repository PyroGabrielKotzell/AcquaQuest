package com.sussy.acquaquest.windows;

import com.sussy.acquaquest.render.Renderer;

public abstract class WindowManager{
    private static Game g = new Game();
    private static Menu m = new Menu();
    private static Die d = new Die();
    private static boolean die = false;

    public static void init(){
        m.load();
    }

    public static void update(){
        if (die) {
            die();
            die = false;
        }
        if (m.isLoaded) m.update();
        else if(g.isLoaded) g.update();
        else d.update();
    }

    public static void changeWindow() {
        if (m.isLoaded){
            m.unload();
            g.load();
        }else if (g.isLoaded){
            g.unload();
            m.load();
        }else{
            d.unload();
            m.load();
        }
    }

    public static void dispose() {
        m.dispose();
        g.dispose();
        d.dispose();
    }
    
    public static Game getG() {
        return g;
    }

    public static void setG(Game g) {
        WindowManager.g = g;
    }

    public static Menu getM() {
        return m;
    }

    public static void setM(Menu m) {
        WindowManager.m = m;
    }

    public static Renderer getRenderer() {
        if (m.isLoaded) return m.getRenderer();
        else if (g.isLoaded) return g.getRenderer();
        else d.getRenderer();
        return null;
    }

    public static void dieScreen() {
        die = true;
    }

    private static void die() {
        if (m.isLoaded) m.unload();
        if (g.isLoaded) g.unload();
        d.load();
    }
}