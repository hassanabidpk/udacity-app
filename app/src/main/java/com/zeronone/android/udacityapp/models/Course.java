package com.zeronone.android.udacityapp.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by zeronone on 12/18/14.
 */
public class Course {

    private String key;
    private String title;
    private String homepage;
    private String subtitle;
    private String level;
    private boolean starter;
    private String image;
    private String bannerImage;
    //private String teaser_video;
    private String summary;
    private String shortSummary;
    private String requiredKnowledge;
    private String expectedLearning;
    private boolean featured;
    private String syllabus;
    private String faq;
    private boolean fullCourseAvailable;

    public String getShortSummary() {
        return shortSummary;
    }

    public void setShortSummary(String shortSummary) {
        this.shortSummary = shortSummary;
    }

    public String getRequiredKnowledge() {
        return requiredKnowledge;
    }

    public void setRequiredKnowledge(String requiredKnowledge) {
        this.requiredKnowledge = requiredKnowledge;
    }

    public String getExpectedLearning() {
        return expectedLearning;
    }

    public void setExpectedLearning(String expectedLearning) {
        this.expectedLearning = expectedLearning;
    }

    public boolean isFullCourseAvailable() {
        return fullCourseAvailable;
    }

    public void setFullCourseAvailable(boolean fullCourseAvailable) {
        this.fullCourseAvailable = fullCourseAvailable;
    }

    public int getExpectedDuration() {
        return expectedDuration;
    }

    public void setExpectedDuration(int expectedDuration) {
        this.expectedDuration = expectedDuration;
    }

    public String getExpectedDurationUnit() {
        return expectedDurationUnit;
    }

    public void setExpectedDurationUnit(String expectedDurationUnit) {
        this.expectedDurationUnit = expectedDurationUnit;
    }

    public boolean isNewRelease() {
        return newRelease;
    }

    public void setNewRelease(boolean newRelease) {
        this.newRelease = newRelease;
    }

    private int expectedDuration;
    private String expectedDurationUnit;
    private boolean newRelease;
    private String[] tracks;
    private Instructor[] instructors;
    private Affiliate[] affiliates;




    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public boolean isStarter() {
        return starter;
    }

    public void setStarter(boolean starter) {
        this.starter = starter;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBannerImage() {
        return bannerImage;
    }

    public void setBannerImage(String bannerImage) {
        this.bannerImage = bannerImage;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }


    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    public String getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(String syllabus) {
        this.syllabus = syllabus;
    }

    public String getFaq() {
        return faq;
    }

    public void setFaq(String faq) {
        this.faq = faq;
    }


    public String[] getTracks() {
        return tracks;
    }

    public void setTracks(String[] tracks) {
        this.tracks = tracks;
    }

    public Instructor[] getInstructors() {
        return instructors;
    }

    public void setInstructors(Instructor[] instructors) {
        this.instructors = instructors;
    }

    public Affiliate[] getAffiliates() {
        return affiliates;
    }

    public void setAffiliates(Affiliate[] affiliates) {
        this.affiliates = affiliates;
    }

}
