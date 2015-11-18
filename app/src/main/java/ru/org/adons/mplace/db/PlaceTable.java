package ru.org.adons.mplace.db;

public final class PlaceTable {

    private PlaceTable() {
    }

    public static final String TABLE_NAME = "places";
    public static final String _ID = "_id";
    public static final String NAME = "name";
    public static final String DATE = "date";
    public static final String DESCRIPTION = "description";
    public static final String THUMBNAIL = "thumbnail";
    public static final String IMAGE_PATH = "image_path";
    public static final String[] PLACES_SUMMARY_PROJECTION = new String[]{
            _ID,
            NAME,
            DATE,
            DESCRIPTION,
            THUMBNAIL,
            IMAGE_PATH
    };
    public static final int COLUMN_ID_INDEX = 0;
    public static final int COLUMN_NAME_INDEX = 1;
    public static final int COLUMN_DATE_INDEX = 2;
    public static final int COLUMN_DESCRIPTION_INDEX = 3;
    public static final int COLUMN_THUMBNAIL_INDEX = 4;
    public static final int COLUMN_IMAGE_PATH_INDEX = 5;
    public static final String DEFAULT_SORT_ORDER = "date DESC";

}
