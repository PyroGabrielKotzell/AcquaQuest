package com.sussy.acquaquest.windows;

import com.sussy.acquaquest.logic.ResourceLoader;

public abstract class WindowManager{
    private Game g = new Game();
    private Menu m = new Menu();

    public static void init(){
        m.load();
    }
}