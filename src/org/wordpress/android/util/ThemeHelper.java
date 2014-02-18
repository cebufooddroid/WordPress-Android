package org.wordpress.android.util;

import java.util.HashMap;
import java.util.Map;

/** 
 * A helper class to retrieve the labels for a given feature based on the tag supplied by the api. 
 *
 */
public class ThemeHelper {

    private static Map<String, String> mTagToLabelMap;
    
    
    public static String getLabel(String feature_tag) {
        if (mTagToLabelMap == null) {
            initMap();
        }
        return mTagToLabelMap.get(feature_tag);
    }


    private static void initMap() {
        mTagToLabelMap = new HashMap<String, String>();
        //Columns
        mTagToLabelMap.put("one-column", "One Column");
        mTagToLabelMap.put("two-columns", "Two Columns");
        mTagToLabelMap.put("three-columns", "Three Columns");
        mTagToLabelMap.put("four-columns", "Four Columns");
        mTagToLabelMap.put("left-sidebar", "Left Sidebar");
        mTagToLabelMap.put("right-sidebar", "Right Sidebar");
        //Layout
        mTagToLabelMap.put("fixed-width", "Fixed Width");
        mTagToLabelMap.put("flexible-width", "Flexible Width");
        mTagToLabelMap.put("responsive-width", "Responsive Width");
        mTagToLabelMap.put("fixed-layout", "Fixed Layout");
        mTagToLabelMap.put("flexible-layout", "Flexible Layout");
        mTagToLabelMap.put("responsive-layout", "Responsive Layout");
        //Features
        mTagToLabelMap.put("custom-background", "Custom Background");
        mTagToLabelMap.put("custom-colors", "Custom Colors");
        mTagToLabelMap.put("custom-header", "Custom Header");
        mTagToLabelMap.put("custom-menu", "Custom Menu");
        mTagToLabelMap.put("editor-style", "Editor Style");
        mTagToLabelMap.put("featured-image-header", "Featured Header");
        mTagToLabelMap.put("featured-images", "Featured Images");
        mTagToLabelMap.put("flexible-header", "Flexible Header");
        mTagToLabelMap.put("front-page-post-form", "Front Page Posting");
        mTagToLabelMap.put("full-width-template", "Full Width Template");
        mTagToLabelMap.put("infinite-scroll", "Infinite Scroll");
        mTagToLabelMap.put("microformats", "Microformats");
        mTagToLabelMap.put("post-formats", "Post Formats");
        mTagToLabelMap.put("post-slider", "Post Slider");
        mTagToLabelMap.put("rtl-language-support", "RTL Language Support");
        mTagToLabelMap.put("sticky-post", "Sticky Post");
        mTagToLabelMap.put("theme-options", "Theme Options");
        mTagToLabelMap.put("translation-ready", "Translation Ready");
    }
    
}
