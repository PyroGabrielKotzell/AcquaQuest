package com.sussy.acquaquest.windows;

public abstract class WindowManager{
    private static Game g = new Game();
    private static Menu m = new Menu();

    public static void init(){
        m.load();
    }

    public static void update(){
        if (m.isLoaded) m.update();
        else g.update();
    }

    public static void changeWindow() {
        if (m.isLoaded){
            m.unload();
            g.load();
        }else{
            g.unload();
            m.load();
        }
    }

    public static void dispose() {
        if (m.isLoaded) m.unload();
        else g.unload();
    }
}