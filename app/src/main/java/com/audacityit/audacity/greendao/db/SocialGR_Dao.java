package com.audacityit.audacity.greendao.db;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.SqlUtils;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;

import com.audacityit.audacity.greendao.db.SocialGR_;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "SOCIAL_GR_".
*/
public class SocialGR_Dao extends AbstractDao<SocialGR_, Long> {

    public static final String TABLENAME = "SOCIAL_GR_";

    /**
     * Properties of entity SocialGR_.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property Image = new Property(2, String.class, "image", false, "IMAGE");
        public final static Property Url = new Property(3, String.class, "url", false, "URL");
        public final static Property Social_id = new Property(4, long.class, "social_id", false, "SOCIAL_ID");
    };

    private DaoSession daoSession;

    private Query<SocialGR_> socialGR_SocialGR_ListQuery;

    public SocialGR_Dao(DaoConfig config) {
        super(config);
    }
    
    public SocialGR_Dao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"SOCIAL_GR_\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"NAME\" TEXT," + // 1: name
                "\"IMAGE\" TEXT," + // 2: image
                "\"URL\" TEXT," + // 3: url
                "\"SOCIAL_ID\" INTEGER NOT NULL );"); // 4: social_id
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"SOCIAL_GR_\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, SocialGR_ entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        String image = entity.getImage();
        if (image != null) {
            stmt.bindString(3, image);
        }
 
        String url = entity.getUrl();
        if (url != null) {
            stmt.bindString(4, url);
        }
        stmt.bindLong(5, entity.getSocial_id());
    }

    @Override
    protected void attachEntity(SocialGR_ entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public SocialGR_ readEntity(Cursor cursor, int offset) {
        SocialGR_ entity = new SocialGR_( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // name
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // image
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // url
            cursor.getLong(offset + 4) // social_id
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, SocialGR_ entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setImage(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setUrl(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setSocial_id(cursor.getLong(offset + 4));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(SocialGR_ entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(SocialGR_ entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "socialGR_List" to-many relationship of SocialGR. */
    public List<SocialGR_> _querySocialGR_SocialGR_List(long social_id) {
        synchronized (this) {
            if (socialGR_SocialGR_ListQuery == null) {
                QueryBuilder<SocialGR_> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.Social_id.eq(null));
                socialGR_SocialGR_ListQuery = queryBuilder.build();
            }
        }
        Query<SocialGR_> query = socialGR_SocialGR_ListQuery.forCurrentThread();
        query.setParameter(0, social_id);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getSocialGRDao().getAllColumns());
            builder.append(" FROM SOCIAL_GR_ T");
            builder.append(" LEFT JOIN SOCIAL_GR T0 ON T.\"SOCIAL_ID\"=T0.\"_id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected SocialGR_ loadCurrentDeep(Cursor cursor, boolean lock) {
        SocialGR_ entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        SocialGR socialGR = loadCurrentOther(daoSession.getSocialGRDao(), cursor, offset);
         if(socialGR != null) {
            entity.setSocialGR(socialGR);
        }

        return entity;    
    }

    public SocialGR_ loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<SocialGR_> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<SocialGR_> list = new ArrayList<SocialGR_>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<SocialGR_> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<SocialGR_> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
