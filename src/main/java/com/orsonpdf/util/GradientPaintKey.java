/* =====================================================================
 * OrsonPDF : a fast, light-weight PDF library for the Java(tm) platform
 * =====================================================================
 * 
 * (C)opyright 2013, by Object Refinery Limited.  All rights reserved.
 *
 * Project Info:  http://www.object-refinery.com/pdf/index.html
 */

package com.orsonpdf.util;

import java.awt.GradientPaint;

/**
 * A wrapper for a <code>GradientPaint</code> that can be used as the key for 
 * a <code>HashMap</code>.  This class is used internally by 
 * <code>PDFGraphics2D</code> to track and re-use gradient definitions.  
 * <code>GradientPaint</code> itself does not implement the equals() and 
 * hashCode() methods, so it doesn't make a good key for a <code>Map</code>.
 */
public final class GradientPaintKey {

    private GradientPaint paint;
    
    /**
     * Creates a new instance based on the specified <code>paint</code>.
     * 
     * @param paint  the paint (<code>null</code> not permitted). 
     */
    public GradientPaintKey(GradientPaint paint) {
        Args.nullNotPermitted(paint, "paint");
        this.paint = paint;
    }
    
    /**
     * Returns the <code>GradientPaint</code> that was supplied to the 
     * constructor.
     * 
     * @return The <code>GradientPaint</code> (never <code>null</code>). 
     */
    public GradientPaint getPaint() {
        return this.paint;
    }
    
    /**
     * Checks this instance for equality with an arbitrary object.
     * 
     * @param obj  the object to test against (<code>null</code> permitted).
     * 
     * @return A boolean. 
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GradientPaintKey)) {
            return false;
        }
        GradientPaintKey that = (GradientPaintKey) obj;
        GradientPaint thisGP = this.paint;
        GradientPaint thatGP = that.getPaint();
        if (!thisGP.getColor1().equals(thatGP.getColor1())) {
            return false;
        }
        if (!thisGP.getColor2().equals(thatGP.getColor2())) {
            return false;
        }
        if (!thisGP.getPoint1().equals(thatGP.getPoint1())) {
            return false;
        }
        if (!thisGP.getPoint2().equals(thatGP.getPoint2())) {
            return false;
        }
        if (thisGP.getTransparency() != thatGP.getTransparency()) {
            return false;
        }
        if (thisGP.isCyclic() != thatGP.isCyclic()) {
            return false;
        }
        return true;
    }

    /**
     * Returns a hash code for this instance.
     * 
     * @return A hash code. 
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.paint.getPoint1().hashCode();
        hash = 47 * hash + this.paint.getPoint2().hashCode();
        hash = 47 * hash + this.paint.getColor1().hashCode();
        hash = 47 * hash + this.paint.getColor2().hashCode();
        return hash;
    }

}
