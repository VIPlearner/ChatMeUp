package com.android.chatmeup.data.db.room_db;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.android.chatmeup.data.db.room_db.dao.ChatDao;
import com.android.chatmeup.data.db.room_db.dao.ChatDao_Impl;
import com.android.chatmeup.data.db.room_db.dao.ContactDao;
import com.android.chatmeup.data.db.room_db.dao.ContactDao_Impl;
import com.android.chatmeup.data.db.room_db.dao.MessageDao;
import com.android.chatmeup.data.db.room_db.dao.MessageDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class ChatMeUpDatabase_Impl extends ChatMeUpDatabase {
  private volatile ChatDao _chatDao;

  private volatile MessageDao _messageDao;

  private volatile ContactDao _contactDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(2) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `RoomChat` (`id` TEXT NOT NULL, `no_of_unread_messages` INTEGER NOT NULL, `displayName` TEXT NOT NULL, `lastMessageText` TEXT NOT NULL, `lastMessageTime` INTEGER NOT NULL, `messageType` TEXT NOT NULL, `lastMessageSenderID` TEXT NOT NULL, `otherUserId` TEXT NOT NULL, `profilePhotoPath` TEXT NOT NULL, `onlineProfilePhotoPath` TEXT NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `RoomMessage` (`messageID` TEXT NOT NULL, `timeStamp` TEXT NOT NULL, `messageText` TEXT NOT NULL, `messageTime` INTEGER NOT NULL, `messageType` TEXT NOT NULL, `senderID` TEXT NOT NULL, `localThumbnailPath` TEXT, `serverThumbnailPath` TEXT, `localFilePath` TEXT, `serverFilePath` TEXT, `messageStatus` TEXT NOT NULL, `chatID` TEXT NOT NULL, PRIMARY KEY(`messageID`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `RoomContact` (`userID` TEXT NOT NULL, `displayName` TEXT NOT NULL, `email` TEXT NOT NULL, `aboutStr` TEXT NOT NULL, `localProfilePhotoPath` TEXT NOT NULL, `onlinePhotoPath` TEXT NOT NULL, `isOnline` INTEGER NOT NULL, PRIMARY KEY(`userID`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'f54240358474305e1e2b5c14d73af029')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `RoomChat`");
        _db.execSQL("DROP TABLE IF EXISTS `RoomMessage`");
        _db.execSQL("DROP TABLE IF EXISTS `RoomContact`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      public void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsRoomChat = new HashMap<String, TableInfo.Column>(10);
        _columnsRoomChat.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRoomChat.put("no_of_unread_messages", new TableInfo.Column("no_of_unread_messages", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRoomChat.put("displayName", new TableInfo.Column("displayName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRoomChat.put("lastMessageText", new TableInfo.Column("lastMessageText", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRoomChat.put("lastMessageTime", new TableInfo.Column("lastMessageTime", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRoomChat.put("messageType", new TableInfo.Column("messageType", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRoomChat.put("lastMessageSenderID", new TableInfo.Column("lastMessageSenderID", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRoomChat.put("otherUserId", new TableInfo.Column("otherUserId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRoomChat.put("profilePhotoPath", new TableInfo.Column("profilePhotoPath", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRoomChat.put("onlineProfilePhotoPath", new TableInfo.Column("onlineProfilePhotoPath", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysRoomChat = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesRoomChat = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoRoomChat = new TableInfo("RoomChat", _columnsRoomChat, _foreignKeysRoomChat, _indicesRoomChat);
        final TableInfo _existingRoomChat = TableInfo.read(_db, "RoomChat");
        if (! _infoRoomChat.equals(_existingRoomChat)) {
          return new RoomOpenHelper.ValidationResult(false, "RoomChat(com.android.chatmeup.data.db.room_db.entity.RoomChat).\n"
                  + " Expected:\n" + _infoRoomChat + "\n"
                  + " Found:\n" + _existingRoomChat);
        }
        final HashMap<String, TableInfo.Column> _columnsRoomMessage = new HashMap<String, TableInfo.Column>(12);
        _columnsRoomMessage.put("messageID", new TableInfo.Column("messageID", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRoomMessage.put("timeStamp", new TableInfo.Column("timeStamp", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRoomMessage.put("messageText", new TableInfo.Column("messageText", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRoomMessage.put("messageTime", new TableInfo.Column("messageTime", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRoomMessage.put("messageType", new TableInfo.Column("messageType", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRoomMessage.put("senderID", new TableInfo.Column("senderID", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRoomMessage.put("localThumbnailPath", new TableInfo.Column("localThumbnailPath", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRoomMessage.put("serverThumbnailPath", new TableInfo.Column("serverThumbnailPath", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRoomMessage.put("localFilePath", new TableInfo.Column("localFilePath", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRoomMessage.put("serverFilePath", new TableInfo.Column("serverFilePath", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRoomMessage.put("messageStatus", new TableInfo.Column("messageStatus", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRoomMessage.put("chatID", new TableInfo.Column("chatID", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysRoomMessage = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesRoomMessage = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoRoomMessage = new TableInfo("RoomMessage", _columnsRoomMessage, _foreignKeysRoomMessage, _indicesRoomMessage);
        final TableInfo _existingRoomMessage = TableInfo.read(_db, "RoomMessage");
        if (! _infoRoomMessage.equals(_existingRoomMessage)) {
          return new RoomOpenHelper.ValidationResult(false, "RoomMessage(com.android.chatmeup.data.db.room_db.entity.RoomMessage).\n"
                  + " Expected:\n" + _infoRoomMessage + "\n"
                  + " Found:\n" + _existingRoomMessage);
        }
        final HashMap<String, TableInfo.Column> _columnsRoomContact = new HashMap<String, TableInfo.Column>(7);
        _columnsRoomContact.put("userID", new TableInfo.Column("userID", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRoomContact.put("displayName", new TableInfo.Column("displayName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRoomContact.put("email", new TableInfo.Column("email", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRoomContact.put("aboutStr", new TableInfo.Column("aboutStr", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRoomContact.put("localProfilePhotoPath", new TableInfo.Column("localProfilePhotoPath", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRoomContact.put("onlinePhotoPath", new TableInfo.Column("onlinePhotoPath", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRoomContact.put("isOnline", new TableInfo.Column("isOnline", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysRoomContact = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesRoomContact = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoRoomContact = new TableInfo("RoomContact", _columnsRoomContact, _foreignKeysRoomContact, _indicesRoomContact);
        final TableInfo _existingRoomContact = TableInfo.read(_db, "RoomContact");
        if (! _infoRoomContact.equals(_existingRoomContact)) {
          return new RoomOpenHelper.ValidationResult(false, "RoomContact(com.android.chatmeup.data.db.room_db.entity.RoomContact).\n"
                  + " Expected:\n" + _infoRoomContact + "\n"
                  + " Found:\n" + _existingRoomContact);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "f54240358474305e1e2b5c14d73af029", "e21a70c7c5077fdece21eb2661beeb05");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "RoomChat","RoomMessage","RoomContact");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `RoomChat`");
      _db.execSQL("DELETE FROM `RoomMessage`");
      _db.execSQL("DELETE FROM `RoomContact`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(ChatDao.class, ChatDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(MessageDao.class, MessageDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ContactDao.class, ContactDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public ChatDao getChatDao() {
    if (_chatDao != null) {
      return _chatDao;
    } else {
      synchronized(this) {
        if(_chatDao == null) {
          _chatDao = new ChatDao_Impl(this);
        }
        return _chatDao;
      }
    }
  }

  @Override
  public MessageDao getMessageDao() {
    if (_messageDao != null) {
      return _messageDao;
    } else {
      synchronized(this) {
        if(_messageDao == null) {
          _messageDao = new MessageDao_Impl(this);
        }
        return _messageDao;
      }
    }
  }

  @Override
  public ContactDao getContactDao() {
    if (_contactDao != null) {
      return _contactDao;
    } else {
      synchronized(this) {
        if(_contactDao == null) {
          _contactDao = new ContactDao_Impl(this);
        }
        return _contactDao;
      }
    }
  }
}
