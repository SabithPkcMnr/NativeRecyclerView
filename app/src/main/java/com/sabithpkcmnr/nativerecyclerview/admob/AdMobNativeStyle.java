package com.sabithpkcmnr.nativerecyclerview.admob;

import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;

public class AdMobNativeStyle {

  // Call to action typeface.
  private Typeface callToActionTextTypeface;

  // Size of call to action text.
  private float callToActionTextSize;

  // Call to action typeface color in the form 0xAARRGGBB.
  private int callToActionTypefaceColor;

  // Call to action background color.
  private ColorDrawable callToActionBackgroundColor;

  // All templates have a primary text area which is populated by the native ad's headline.

  // Primary text typeface.
  private Typeface primaryTextTypeface;

  // Size of primary text.
  private float primaryTextSize;

  // Primary text typeface color in the form 0xAARRGGBB.
  private int primaryTextTypefaceColor;

  // Primary text background color.
  private ColorDrawable primaryTextBackgroundColor;

  // The typeface, typeface color, and background color for the second row of text in the template.
  // All templates have a secondary text area which is populated either by the body of the ad or
  // by the rating of the app.

  // Secondary text typeface.
  private Typeface secondaryTextTypeface;

  // Size of secondary text.
  private float secondaryTextSize;

  // Secondary text typeface color in the form 0xAARRGGBB.
  private int secondaryTextTypefaceColor;

  // Secondary text background color.
  private ColorDrawable secondaryTextBackgroundColor;

  // The typeface, typeface color, and background color for the third row of text in the template.
  // The third row is used to display store name or the default tertiary text.

  // Tertiary text typeface.
  private Typeface tertiaryTextTypeface;

  // Size of tertiary text.
  private float tertiaryTextSize;

  // Tertiary text typeface color in the form 0xAARRGGBB.
  private int tertiaryTextTypefaceColor;

  // Tertiary text background color.
  private ColorDrawable tertiaryTextBackgroundColor;

  // The background color for the bulk of the ad.
  private ColorDrawable mainBackgroundColor;

  public Typeface getCallToActionTextTypeface() {
    return callToActionTextTypeface;
  }

  public float getCallToActionTextSize() {
    return callToActionTextSize;
  }

  public int getCallToActionTypefaceColor() {
    return callToActionTypefaceColor;
  }

  public ColorDrawable getCallToActionBackgroundColor() {
    return callToActionBackgroundColor;
  }

  public Typeface getPrimaryTextTypeface() {
    return primaryTextTypeface;
  }

  public float getPrimaryTextSize() {
    return primaryTextSize;
  }

  public int getPrimaryTextTypefaceColor() {
    return primaryTextTypefaceColor;
  }

  public ColorDrawable getPrimaryTextBackgroundColor() {
    return primaryTextBackgroundColor;
  }

  public Typeface getSecondaryTextTypeface() {
    return secondaryTextTypeface;
  }

  public float getSecondaryTextSize() {
    return secondaryTextSize;
  }

  public int getSecondaryTextTypefaceColor() {
    return secondaryTextTypefaceColor;
  }

  public ColorDrawable getSecondaryTextBackgroundColor() {
    return secondaryTextBackgroundColor;
  }

  public Typeface getTertiaryTextTypeface() {
    return tertiaryTextTypeface;
  }

  public float getTertiaryTextSize() {
    return tertiaryTextSize;
  }

  public int getTertiaryTextTypefaceColor() {
    return tertiaryTextTypefaceColor;
  }

  public ColorDrawable getTertiaryTextBackgroundColor() {
    return tertiaryTextBackgroundColor;
  }

  public ColorDrawable getMainBackgroundColor() {
    return mainBackgroundColor;
  }

  /** A class that provides helper methods to build a style object. * */
  public static class Builder {

    private AdMobNativeStyle styles;

    public Builder() {
      this.styles = new AdMobNativeStyle();
    }

    public Builder withCallToActionTextTypeface(Typeface callToActionTextTypeface) {
      this.styles.callToActionTextTypeface = callToActionTextTypeface;
      return this;
    }

    public Builder withCallToActionTextSize(float callToActionTextSize) {
      this.styles.callToActionTextSize = callToActionTextSize;
      return this;
    }

    public Builder withCallToActionTypefaceColor(int callToActionTypefaceColor) {
      this.styles.callToActionTypefaceColor = callToActionTypefaceColor;
      return this;
    }

    public Builder withCallToActionBackgroundColor(ColorDrawable callToActionBackgroundColor) {
      this.styles.callToActionBackgroundColor = callToActionBackgroundColor;
      return this;
    }

    public Builder withPrimaryTextTypeface(Typeface primaryTextTypeface) {
      this.styles.primaryTextTypeface = primaryTextTypeface;
      return this;
    }

    public Builder withPrimaryTextSize(float primaryTextSize) {
      this.styles.primaryTextSize = primaryTextSize;
      return this;
    }

    public Builder withPrimaryTextTypefaceColor(int primaryTextTypefaceColor) {
      this.styles.primaryTextTypefaceColor = primaryTextTypefaceColor;
      return this;
    }

    public Builder withPrimaryTextBackgroundColor(ColorDrawable primaryTextBackgroundColor) {
      this.styles.primaryTextBackgroundColor = primaryTextBackgroundColor;
      return this;
    }

    public Builder withSecondaryTextTypeface(Typeface secondaryTextTypeface) {
      this.styles.secondaryTextTypeface = secondaryTextTypeface;
      return this;
    }

    public Builder withSecondaryTextSize(float secondaryTextSize) {
      this.styles.secondaryTextSize = secondaryTextSize;
      return this;
    }

    public Builder withSecondaryTextTypefaceColor(int secondaryTextTypefaceColor) {
      this.styles.secondaryTextTypefaceColor = secondaryTextTypefaceColor;
      return this;
    }

    public Builder withSecondaryTextBackgroundColor(ColorDrawable secondaryTextBackgroundColor) {
      this.styles.secondaryTextBackgroundColor = secondaryTextBackgroundColor;
      return this;
    }

    public Builder withTertiaryTextTypeface(Typeface tertiaryTextTypeface) {
      this.styles.tertiaryTextTypeface = tertiaryTextTypeface;
      return this;
    }

    public Builder withTertiaryTextSize(float tertiaryTextSize) {
      this.styles.tertiaryTextSize = tertiaryTextSize;
      return this;
    }

    public Builder withTertiaryTextTypefaceColor(int tertiaryTextTypefaceColor) {
      this.styles.tertiaryTextTypefaceColor = tertiaryTextTypefaceColor;
      return this;
    }

    public Builder withTertiaryTextBackgroundColor(ColorDrawable tertiaryTextBackgroundColor) {
      this.styles.tertiaryTextBackgroundColor = tertiaryTextBackgroundColor;
      return this;
    }

    public Builder withMainBackgroundColor(ColorDrawable mainBackgroundColor) {
      this.styles.mainBackgroundColor = mainBackgroundColor;
      return this;
    }

    public AdMobNativeStyle build() {
      return styles;
    }
  }
}
