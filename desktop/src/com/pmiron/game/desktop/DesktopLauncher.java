package com.pmiron.game.desktop;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.pmiron.game.PmIronMain;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.title = "Pokemon Iron";
		config.height = 400;
		config.width = 600;

		new LwjglApplication(new PmIronMain(), config);
	}
}
