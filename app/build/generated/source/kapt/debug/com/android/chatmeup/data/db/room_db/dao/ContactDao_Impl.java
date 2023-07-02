package com.android.chatmeup.data.db.room_db.dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.EntityUpsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.android.chatmeup.data.db.room_db.entity.RoomContact;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class ContactDao_Impl implements ContactDao {
  private final RoomDatabase __db;

  private final EntityDeletionOrUpdateAdapter<RoomContact> __deletionAdapterOfRoomContact;

  private final SharedSQLiteStatement __preparedStmtOfDeleteTable;

  private final EntityUpsertionAdapter<RoomContact> __upsertionAdapterOfRoomContact;

  public ContactDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__deletionAdapterOfRoomContact = new EntityDeletionOrUpdateAdapter<RoomContact>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `RoomContact` WHERE `userID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, RoomContact value) {
        if (value.getUserID() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUserID());
        }
      }
    };
    this.__preparedStmtOfDeleteTable = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM roomcontact";
        return _query;
      }
    };
    this.__upsertionAdapterOfRoomContact = new EntityUpsertionAdapter<RoomContact>(new EntityInsertionAdapter<RoomContact>(__db) {
      @Override
      public String createQuery() {
        return "INSERT INTO `RoomContact` (`userID`,`displayName`,`email`,`aboutStr`,`localProfilePhotoPath`,`onlinePhotoPath`,`isOnline`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, RoomContact value) {
        if (value.getUserID() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUserID());
        }
        if (value.getDisplayName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getDisplayName());
        }
        if (value.getEmail() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getEmail());
        }
        if (value.getAboutStr() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getAboutStr());
        }
        if (value.getLocalProfilePhotoPath() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getLocalProfilePhotoPath());
        }
        if (value.getOnlinePhotoPath() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getOnlinePhotoPath());
        }
        final int _tmp = value.isOnline() ? 1 : 0;
        stmt.bindLong(7, _tmp);
      }
    }, new EntityDeletionOrUpdateAdapter<RoomContact>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE `RoomContact` SET `userID` = ?,`displayName` = ?,`email` = ?,`aboutStr` = ?,`localProfilePhotoPath` = ?,`onlinePhotoPath` = ?,`isOnline` = ? WHERE `userID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, RoomContact value) {
        if (value.getUserID() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUserID());
        }
        if (value.getDisplayName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getDisplayName());
        }
        if (value.getEmail() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getEmail());
        }
        if (value.getAboutStr() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getAboutStr());
        }
        if (value.getLocalProfilePhotoPath() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getLocalProfilePhotoPath());
        }
        if (value.getOnlinePhotoPath() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getOnlinePhotoPath());
        }
        final int _tmp = value.isOnline() ? 1 : 0;
        stmt.bindLong(7, _tmp);
        if (value.getUserID() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getUserID());
        }
      }
    });
  }

  @Override
  public void deleteContact(final RoomContact roomContact) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfRoomContact.handle(roomContact);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteTable() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteTable.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteTable.release(_stmt);
    }
  }

  @Override
  public void upsertContact(final RoomContact roomContact) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __upsertionAdapterOfRoomContact.upsert(roomContact);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Flow<List<RoomContact>> getContactsFlow() {
    final String _sql = "SELECT * FROM roomcontact";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"roomcontact"}, new Callable<List<RoomContact>>() {
      @Override
      public List<RoomContact> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUserID = CursorUtil.getColumnIndexOrThrow(_cursor, "userID");
          final int _cursorIndexOfDisplayName = CursorUtil.getColumnIndexOrThrow(_cursor, "displayName");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfAboutStr = CursorUtil.getColumnIndexOrThrow(_cursor, "aboutStr");
          final int _cursorIndexOfLocalProfilePhotoPath = CursorUtil.getColumnIndexOrThrow(_cursor, "localProfilePhotoPath");
          final int _cursorIndexOfOnlinePhotoPath = CursorUtil.getColumnIndexOrThrow(_cursor, "onlinePhotoPath");
          final int _cursorIndexOfIsOnline = CursorUtil.getColumnIndexOrThrow(_cursor, "isOnline");
          final List<RoomContact> _result = new ArrayList<RoomContact>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final RoomContact _item;
            final String _tmpUserID;
            if (_cursor.isNull(_cursorIndexOfUserID)) {
              _tmpUserID = null;
            } else {
              _tmpUserID = _cursor.getString(_cursorIndexOfUserID);
            }
            final String _tmpDisplayName;
            if (_cursor.isNull(_cursorIndexOfDisplayName)) {
              _tmpDisplayName = null;
            } else {
              _tmpDisplayName = _cursor.getString(_cursorIndexOfDisplayName);
            }
            final String _tmpEmail;
            if (_cursor.isNull(_cursorIndexOfEmail)) {
              _tmpEmail = null;
            } else {
              _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            }
            final String _tmpAboutStr;
            if (_cursor.isNull(_cursorIndexOfAboutStr)) {
              _tmpAboutStr = null;
            } else {
              _tmpAboutStr = _cursor.getString(_cursorIndexOfAboutStr);
            }
            final String _tmpLocalProfilePhotoPath;
            if (_cursor.isNull(_cursorIndexOfLocalProfilePhotoPath)) {
              _tmpLocalProfilePhotoPath = null;
            } else {
              _tmpLocalProfilePhotoPath = _cursor.getString(_cursorIndexOfLocalProfilePhotoPath);
            }
            final String _tmpOnlinePhotoPath;
            if (_cursor.isNull(_cursorIndexOfOnlinePhotoPath)) {
              _tmpOnlinePhotoPath = null;
            } else {
              _tmpOnlinePhotoPath = _cursor.getString(_cursorIndexOfOnlinePhotoPath);
            }
            final boolean _tmpIsOnline;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsOnline);
            _tmpIsOnline = _tmp != 0;
            _item = new RoomContact(_tmpUserID,_tmpDisplayName,_tmpEmail,_tmpAboutStr,_tmpLocalProfilePhotoPath,_tmpOnlinePhotoPath,_tmpIsOnline);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public List<RoomContact> getContacts() {
    final String _sql = "SELECT * FROM roomcontact";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUserID = CursorUtil.getColumnIndexOrThrow(_cursor, "userID");
      final int _cursorIndexOfDisplayName = CursorUtil.getColumnIndexOrThrow(_cursor, "displayName");
      final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
      final int _cursorIndexOfAboutStr = CursorUtil.getColumnIndexOrThrow(_cursor, "aboutStr");
      final int _cursorIndexOfLocalProfilePhotoPath = CursorUtil.getColumnIndexOrThrow(_cursor, "localProfilePhotoPath");
      final int _cursorIndexOfOnlinePhotoPath = CursorUtil.getColumnIndexOrThrow(_cursor, "onlinePhotoPath");
      final int _cursorIndexOfIsOnline = CursorUtil.getColumnIndexOrThrow(_cursor, "isOnline");
      final List<RoomContact> _result = new ArrayList<RoomContact>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final RoomContact _item;
        final String _tmpUserID;
        if (_cursor.isNull(_cursorIndexOfUserID)) {
          _tmpUserID = null;
        } else {
          _tmpUserID = _cursor.getString(_cursorIndexOfUserID);
        }
        final String _tmpDisplayName;
        if (_cursor.isNull(_cursorIndexOfDisplayName)) {
          _tmpDisplayName = null;
        } else {
          _tmpDisplayName = _cursor.getString(_cursorIndexOfDisplayName);
        }
        final String _tmpEmail;
        if (_cursor.isNull(_cursorIndexOfEmail)) {
          _tmpEmail = null;
        } else {
          _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        }
        final String _tmpAboutStr;
        if (_cursor.isNull(_cursorIndexOfAboutStr)) {
          _tmpAboutStr = null;
        } else {
          _tmpAboutStr = _cursor.getString(_cursorIndexOfAboutStr);
        }
        final String _tmpLocalProfilePhotoPath;
        if (_cursor.isNull(_cursorIndexOfLocalProfilePhotoPath)) {
          _tmpLocalProfilePhotoPath = null;
        } else {
          _tmpLocalProfilePhotoPath = _cursor.getString(_cursorIndexOfLocalProfilePhotoPath);
        }
        final String _tmpOnlinePhotoPath;
        if (_cursor.isNull(_cursorIndexOfOnlinePhotoPath)) {
          _tmpOnlinePhotoPath = null;
        } else {
          _tmpOnlinePhotoPath = _cursor.getString(_cursorIndexOfOnlinePhotoPath);
        }
        final boolean _tmpIsOnline;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsOnline);
        _tmpIsOnline = _tmp != 0;
        _item = new RoomContact(_tmpUserID,_tmpDisplayName,_tmpEmail,_tmpAboutStr,_tmpLocalProfilePhotoPath,_tmpOnlinePhotoPath,_tmpIsOnline);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Flow<RoomContact> getContactFlow(final String userID) {
    final String _sql = "SELECT * FROM roomcontact WHERE ? == userID";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (userID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userID);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[]{"roomcontact"}, new Callable<RoomContact>() {
      @Override
      public RoomContact call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUserID = CursorUtil.getColumnIndexOrThrow(_cursor, "userID");
          final int _cursorIndexOfDisplayName = CursorUtil.getColumnIndexOrThrow(_cursor, "displayName");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfAboutStr = CursorUtil.getColumnIndexOrThrow(_cursor, "aboutStr");
          final int _cursorIndexOfLocalProfilePhotoPath = CursorUtil.getColumnIndexOrThrow(_cursor, "localProfilePhotoPath");
          final int _cursorIndexOfOnlinePhotoPath = CursorUtil.getColumnIndexOrThrow(_cursor, "onlinePhotoPath");
          final int _cursorIndexOfIsOnline = CursorUtil.getColumnIndexOrThrow(_cursor, "isOnline");
          final RoomContact _result;
          if(_cursor.moveToFirst()) {
            final String _tmpUserID;
            if (_cursor.isNull(_cursorIndexOfUserID)) {
              _tmpUserID = null;
            } else {
              _tmpUserID = _cursor.getString(_cursorIndexOfUserID);
            }
            final String _tmpDisplayName;
            if (_cursor.isNull(_cursorIndexOfDisplayName)) {
              _tmpDisplayName = null;
            } else {
              _tmpDisplayName = _cursor.getString(_cursorIndexOfDisplayName);
            }
            final String _tmpEmail;
            if (_cursor.isNull(_cursorIndexOfEmail)) {
              _tmpEmail = null;
            } else {
              _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            }
            final String _tmpAboutStr;
            if (_cursor.isNull(_cursorIndexOfAboutStr)) {
              _tmpAboutStr = null;
            } else {
              _tmpAboutStr = _cursor.getString(_cursorIndexOfAboutStr);
            }
            final String _tmpLocalProfilePhotoPath;
            if (_cursor.isNull(_cursorIndexOfLocalProfilePhotoPath)) {
              _tmpLocalProfilePhotoPath = null;
            } else {
              _tmpLocalProfilePhotoPath = _cursor.getString(_cursorIndexOfLocalProfilePhotoPath);
            }
            final String _tmpOnlinePhotoPath;
            if (_cursor.isNull(_cursorIndexOfOnlinePhotoPath)) {
              _tmpOnlinePhotoPath = null;
            } else {
              _tmpOnlinePhotoPath = _cursor.getString(_cursorIndexOfOnlinePhotoPath);
            }
            final boolean _tmpIsOnline;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsOnline);
            _tmpIsOnline = _tmp != 0;
            _result = new RoomContact(_tmpUserID,_tmpDisplayName,_tmpEmail,_tmpAboutStr,_tmpLocalProfilePhotoPath,_tmpOnlinePhotoPath,_tmpIsOnline);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public RoomContact getContact(final String userID) {
    final String _sql = "SELECT * FROM roomcontact WHERE ? == userID";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (userID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userID);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUserID = CursorUtil.getColumnIndexOrThrow(_cursor, "userID");
      final int _cursorIndexOfDisplayName = CursorUtil.getColumnIndexOrThrow(_cursor, "displayName");
      final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
      final int _cursorIndexOfAboutStr = CursorUtil.getColumnIndexOrThrow(_cursor, "aboutStr");
      final int _cursorIndexOfLocalProfilePhotoPath = CursorUtil.getColumnIndexOrThrow(_cursor, "localProfilePhotoPath");
      final int _cursorIndexOfOnlinePhotoPath = CursorUtil.getColumnIndexOrThrow(_cursor, "onlinePhotoPath");
      final int _cursorIndexOfIsOnline = CursorUtil.getColumnIndexOrThrow(_cursor, "isOnline");
      final RoomContact _result;
      if(_cursor.moveToFirst()) {
        final String _tmpUserID;
        if (_cursor.isNull(_cursorIndexOfUserID)) {
          _tmpUserID = null;
        } else {
          _tmpUserID = _cursor.getString(_cursorIndexOfUserID);
        }
        final String _tmpDisplayName;
        if (_cursor.isNull(_cursorIndexOfDisplayName)) {
          _tmpDisplayName = null;
        } else {
          _tmpDisplayName = _cursor.getString(_cursorIndexOfDisplayName);
        }
        final String _tmpEmail;
        if (_cursor.isNull(_cursorIndexOfEmail)) {
          _tmpEmail = null;
        } else {
          _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        }
        final String _tmpAboutStr;
        if (_cursor.isNull(_cursorIndexOfAboutStr)) {
          _tmpAboutStr = null;
        } else {
          _tmpAboutStr = _cursor.getString(_cursorIndexOfAboutStr);
        }
        final String _tmpLocalProfilePhotoPath;
        if (_cursor.isNull(_cursorIndexOfLocalProfilePhotoPath)) {
          _tmpLocalProfilePhotoPath = null;
        } else {
          _tmpLocalProfilePhotoPath = _cursor.getString(_cursorIndexOfLocalProfilePhotoPath);
        }
        final String _tmpOnlinePhotoPath;
        if (_cursor.isNull(_cursorIndexOfOnlinePhotoPath)) {
          _tmpOnlinePhotoPath = null;
        } else {
          _tmpOnlinePhotoPath = _cursor.getString(_cursorIndexOfOnlinePhotoPath);
        }
        final boolean _tmpIsOnline;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsOnline);
        _tmpIsOnline = _tmp != 0;
        _result = new RoomContact(_tmpUserID,_tmpDisplayName,_tmpEmail,_tmpAboutStr,_tmpLocalProfilePhotoPath,_tmpOnlinePhotoPath,_tmpIsOnline);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public boolean contactExists(final String userID) {
    final String _sql = "SELECT EXISTS(SELECT 1 FROM roomcontact WHERE ? = userID)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (userID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userID);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final boolean _result;
      if(_cursor.moveToFirst()) {
        final int _tmp;
        _tmp = _cursor.getInt(0);
        _result = _tmp != 0;
      } else {
        _result = false;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
