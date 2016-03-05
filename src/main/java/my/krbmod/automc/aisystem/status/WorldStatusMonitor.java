package my.krbmod.automc.aisystem.status;

import my.krbmod.automc.utility.LogHelper;
import my.krbmod.automc.utility.ModTime;

public class WorldStatusMonitor {

	/*
	 * Continually maintains the current status and the time the status went
	 * into effect of the following:
	 * 
	 * - Server starting and stopping - World loading and unloading
	 * 
	 */
	public static void preInit() {
		long currentTime = System.currentTimeMillis();
		serverStarted = false; // assume at the beginning that the server is not
								// started
		lastServerTime = currentTime;
		worldLoaded = false; // assume at the beginning that the world is not
								// loaded
		lastWorldTime = currentTime;
		playerLoaded = false; // assume at the beginning that the world is not
								// loaded
		lastPlayerTime = currentTime;
		chunksFinished = false; // assume at the beginning that the world is not
								// loaded
		lastChunkTime = currentTime;

	}

	public static void init() {
	}

	public static void postInit() {
	}

	/*
	 * Server Status
	 */
	private static boolean serverStarted = false;
	private static long lastServerTime = 0;

	public static void startServer() {
		serverStarted = true;
		lastServerTime = System.currentTimeMillis();

	}

	public static void stopServer() {
		if (isWorldLoaded()) {
			unloadWorld(); // chain unloads: assume world can't be loaded if
							// server has stopped
		}

		serverStarted = false;
		LogHelper.info(
				"Server was up for " + ModTime.millisToString(Math.abs((System.currentTimeMillis() - lastServerTime))));
		lastServerTime = System.currentTimeMillis();

	}

	public static boolean isServerStarted() {
		return serverStarted;
	}

	public static long elapsedServerTime() {
		return System.currentTimeMillis() - lastServerTime;
	}

	/*
	 * World Status
	 */
	private static boolean worldLoaded = false;
	private static long lastWorldTime = 0;

	public static void loadWorld() {
		worldLoaded = true;
		lastWorldTime = System.currentTimeMillis();

	}

	public static void unloadWorld() {
		if (isPlayerLoaded()) {
			unloadPlayer(); // chain unloads: assume player can't be loaded if
							// world isn't
		}
		worldLoaded = false;
		LogHelper.info("World was loaded for "
				+ ModTime.millisToString(Math.abs((System.currentTimeMillis() - lastWorldTime))));
		lastWorldTime = System.currentTimeMillis();
	}

	public static boolean isWorldLoaded() {
		return worldLoaded;
	}

	public static long elapsedWorldTime() {
		return System.currentTimeMillis() - lastWorldTime;
	}

	/*
	 * Player Status
	 */
	private static boolean playerLoaded = false;
	private static long lastPlayerTime = 0;

	public static void loadPlayer() {
		playerLoaded = true;
		lastPlayerTime = System.currentTimeMillis();

	}

	public static void unloadPlayer() {
		playerLoaded = false;
		LogHelper.info("Player was loaded for "
				+ ModTime.millisToString(Math.abs((System.currentTimeMillis() - lastPlayerTime))));
		lastPlayerTime = System.currentTimeMillis();
	}

	public static boolean isPlayerLoaded() {
		return playerLoaded;
	}

	public static long elapsedPlayerTime() {
		return System.currentTimeMillis() - lastPlayerTime;
	}

	/*
	 * Chunk Status - When a chunk loads, set chunksFinished to false and reset
	 * the clock when a Chunk load hasn't occurred in a while, we set
	 * chunksFinished to true
	 */
	private static boolean chunksFinished = false;
	private static long lastChunkTime = 0;

	public static void loadChunk() {
		if (elapsedChunkTime() > 500) {
			LogHelper.info("Chunks have not loaded for "
					+ ModTime.millisToString(Math.abs((System.currentTimeMillis() - lastChunkTime))));
		}

		chunksFinished = true;
		lastChunkTime = System.currentTimeMillis();

	}

	public static void finishedChunkLoading() {
		chunksFinished = true;
		LogHelper.info("Chunks have not loaded for "
				+ ModTime.millisToString(Math.abs((System.currentTimeMillis() - lastChunkTime))));
		lastChunkTime = System.currentTimeMillis();
	}

	public static boolean isChunkLoadingFinished() {
		if (chunksFinished == false) {
			if (elapsedChunkTime() > 1000) {
				finishedChunkLoading();
			}
		}
		return chunksFinished;
	}

	public static long elapsedChunkTime() {
		return System.currentTimeMillis() - lastChunkTime;
	}

}
