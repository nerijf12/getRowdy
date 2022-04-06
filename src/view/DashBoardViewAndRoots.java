package view;

public class DashBoardViewAndRoots {
	public static final int VIEW_1 = 1; public static final int VIEW_2 = 2;
	public static final int VIEW_3 = 3; public static final int VIEW_4 = 4;
	
	private static String viewRoot = "/view/";
	private static String controllerRoot = "/controller/";
	private static String assetsRoot = "/assets/";
	private static String assetsCssRoot = "/assets/css/";
	private static String assetsImagesRoot = "/assets/images/";
    
    public static String getViewRoot() {
		return viewRoot;
	}
    
    public static String getControllerRoot() {
		return controllerRoot;
	}
    
    public static String getAssetsRoot() {
		return assetsRoot;
	}
    
    public static String getAssetsCssRoot() {
		return assetsCssRoot;
	}
    
    public static String getAssetsImagesRoot() {
		return assetsImagesRoot;
	}

}
