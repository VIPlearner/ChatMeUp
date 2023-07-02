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
import com.android.chatmeup.data.db.room_db.data.MessageType;
import com.android.chatmeup.data.db.room_db.data.MessageTypeEnumConverter;
import com.android.chatmeup.data.db.room_db.entity.RoomChat;
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
public final class ChatDao_Impl implements ChatDao {
  private final RoomDatabase __db;

  private final EntityDeletionOrUpdateAdapter<RoomChat> __deletionAdapterOfRoomChat;

  private final SharedSQLiteStatement __preparedStmtOfDeleteTable;

  private final EntityUpsertionAdapter<RoomChat> __upsertionAdapterOfRoomChat;

  private final MessageTypeEnumConverter __messageTypeEnumConverter = new MessageTypeEnumConverter();

  public ChatDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__deletionAdapterOfRoomChat = new EntityDeletionOrUpdateAdapter<RoomChat>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `RoomChat` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, RoomChat value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
      }
    };
    this.__preparedStmtOfDeleteTable = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM roomchat";
        return _query;
      }
    };
    this.__upsertionAdapterOfRoomChat = new EntityUpsertionAdapter<RoomChat>(new EntityInsertionAdapter<RoomChat>(__db) {
      @Override
      public String createQuery() {
        return "INSERT INTO `RoomChat` (`id`,`no_of_unread_messages`,`displayName`,`lastMessageText`,`lastMessageTime`,`messageType`,`lastMessageSenderID`,`otherUserId`,`profilePhotoPath`,`onlineProfilePhotoPath`) VALUES (?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, RoomChat value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        stmt.bindLong(2, value.getNo_of_unread_messages());
        if (value.getDisplayName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDisplayName());
        }
        if (value.getLastMessageText() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getLastMessageText());
        }
        stmt.bindLong(5, value.getLastMessageTime());
        final String _tmp = __messageTypeEnumConverter.fromEnum(value.getMessageType());
        if (_tmp == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, _tmp);
        }
        if (value.getLastMessageSenderID() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getLastMessageSenderID());
        }
        if (value.getOtherUserId() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getOtherUserId());
        }
        if (value.getProfilePhotoPath() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getProfilePhotoPath());
        }
        if (value.getOnlineProfilePhotoPath() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getOnlineProfilePhotoPath());
        }
      }
    }, new EntityDeletionOrUpdateAdapter<RoomChat>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE `RoomChat` SET `id` = ?,`no_of_unread_messages` = ?,`displayName` = ?,`lastMessageText` = ?,`lastMessageTime` = ?,`messageType` = ?,`lastMessageSenderID` = ?,`otherUserId` = ?,`profilePhotoPath` = ?,`onlineProfilePhotoPath` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, RoomChat value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        stmt.bindLong(2, value.getNo_of_unread_messages());
        if (value.getDisplayName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDisplayName());
        }
        if (value.getLastMessageText() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getLastMessageText());
        }
        stmt.bindLong(5, value.getLastMessageTime());
        final String _tmp = __messageTypeEnumConverter.fromEnum(value.getMessageType());
        if (_tmp == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, _tmp);
        }
        if (value.getLastMessageSenderID() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getLastMessageSenderID());
        }
        if (value.getOtherUserId() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getOtherUserId());
        }
        if (value.getProfilePhotoPath() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getProfilePhotoPath());
        }
        if (value.getOnlineProfilePhotoPath() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getOnlineProfilePhotoPath());
        }
        if (value.getId() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getId());
        }
      }
    });
  }

  @Override
  public void deleteChat(final RoomChat roomChat) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfRoomChat.handle(roomChat);
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
  public void upsertChat(final RoomChat roomChat) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __upsertionAdapterOfRoomChat.upsert(roomChat);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public RoomChat getChat(final String chatId) {
    final String _sql = "SELECT * FROM roomchat WHERE ? = id";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (chatId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, chatId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfNoOfUnreadMessages = CursorUtil.getColumnIndexOrThrow(_cursor, "no_of_unread_messages");
      final int _cursorIndexOfDisplayName = CursorUtil.getColumnIndexOrThrow(_cursor, "displayName");
      final int _cursorIndexOfLastMessageText = CursorUtil.getColumnIndexOrThrow(_cursor, "lastMessageText");
      final int _cursorIndexOfLastMessageTime = CursorUtil.getColumnIndexOrThrow(_cursor, "lastMessageTime");
      final int _cursorIndexOfMessageType = CursorUtil.getColumnIndexOrThrow(_cursor, "messageType");
      final int _cursorIndexOfLastMessageSenderID = CursorUtil.getColumnIndexOrThrow(_cursor, "lastMessageSenderID");
      final int _cursorIndexOfOtherUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "otherUserId");
      final int _cursorIndexOfProfilePhotoPath = CursorUtil.getColumnIndexOrThrow(_cursor, "profilePhotoPath");
      final int _cursorIndexOfOnlineProfilePhotoPath = CursorUtil.getColumnIndexOrThrow(_cursor, "onlineProfilePhotoPath");
      final RoomChat _result;
      if(_cursor.moveToFirst()) {
        final String _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getString(_cursorIndexOfId);
        }
        final int _tmpNo_of_unread_messages;
        _tmpNo_of_unread_messages = _cursor.getInt(_cursorIndexOfNoOfUnreadMessages);
        final String _tmpDisplayName;
        if (_cursor.isNull(_cursorIndexOfDisplayName)) {
          _tmpDisplayName = null;
        } else {
          _tmpDisplayName = _cursor.getString(_cursorIndexOfDisplayName);
        }
        final String _tmpLastMessageText;
        if (_cursor.isNull(_cursorIndexOfLastMessageText)) {
          _tmpLastMessageText = null;
        } else {
          _tmpLastMessageText = _cursor.getString(_cursorIndexOfLastMessageText);
        }
        final long _tmpLastMessageTime;
        _tmpLastMessageTime = _cursor.getLong(_cursorIndexOfLastMessageTime);
        final MessageType _tmpMessageType;
        final String _tmp;
        if (_cursor.isNull(_cursorIndexOfMessageType)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getString(_cursorIndexOfMessageType);
        }
        _tmpMessageType = __messageTypeEnumConverter.toEnum(_tmp);
        final String _tmpLastMessageSenderID;
        if (_cursor.isNull(_cursorIndexOfLastMessageSenderID)) {
          _tmpLastMessageSenderID = null;
        } else {
          _tmpLastMessageSenderID = _cursor.getString(_cursorIndexOfLastMessageSenderID);
        }
        final String _tmpOtherUserId;
        if (_cursor.isNull(_cursorIndexOfOtherUserId)) {
          _tmpOtherUserId = null;
        } else {
          _tmpOtherUserId = _cursor.getString(_cursorIndexOfOtherUserId);
        }
        final String _tmpProfilePhotoPath;
        if (_cursor.isNull(_cursorIndexOfProfilePhotoPath)) {
          _tmpProfilePhotoPath = null;
        } else {
          _tmpProfilePhotoPath = _cursor.getString(_cursorIndexOfProfilePhotoPath);
        }
        final String _tmpOnlineProfilePhotoPath;
        if (_cursor.isNull(_cursorIndexOfOnlineProfilePhotoPath)) {
          _tmpOnlineProfilePhotoPath = null;
        } else {
          _tmpOnlineProfilePhotoPath = _cursor.getString(_cursorIndexOfOnlineProfilePhotoPath);
        }
        _result = new RoomChat(_tmpId,_tmpNo_of_unread_messages,_tmpDisplayName,_tmpLastMessageText,_tmpLastMessageTime,_tmpMessageType,_tmpLastMessageSenderID,_tmpOtherUserId,_tmpProfilePhotoPath,_tmpOnlineProfilePhotoPath);
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
  public boolean chatExists(final String chatID) {
    final String _sql = "SELECT EXISTS(SELECT * FROM roomchat WHERE ? = id)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (chatID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, chatID);
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

  @Override
  public Flow<List<RoomChat>> getChatsOrderedByTime() {
    final String _sql = "SELECT * FROM roomchat ORDER BY lastMessageTime DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"roomchat"}, new Callable<List<RoomChat>>() {
      @Override
      public List<RoomChat> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNoOfUnreadMessages = CursorUtil.getColumnIndexOrThrow(_cursor, "no_of_unread_messages");
          final int _cursorIndexOfDisplayName = CursorUtil.getColumnIndexOrThrow(_cursor, "displayName");
          final int _cursorIndexOfLastMessageText = CursorUtil.getColumnIndexOrThrow(_cursor, "lastMessageText");
          final int _cursorIndexOfLastMessageTime = CursorUtil.getColumnIndexOrThrow(_cursor, "lastMessageTime");
          final int _cursorIndexOfMessageType = CursorUtil.getColumnIndexOrThrow(_cursor, "messageType");
          final int _cursorIndexOfLastMessageSenderID = CursorUtil.getColumnIndexOrThrow(_cursor, "lastMessageSenderID");
          final int _cursorIndexOfOtherUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "otherUserId");
          final int _cursorIndexOfProfilePhotoPath = CursorUtil.getColumnIndexOrThrow(_cursor, "profilePhotoPath");
          final int _cursorIndexOfOnlineProfilePhotoPath = CursorUtil.getColumnIndexOrThrow(_cursor, "onlineProfilePhotoPath");
          final List<RoomChat> _result = new ArrayList<RoomChat>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final RoomChat _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final int _tmpNo_of_unread_messages;
            _tmpNo_of_unread_messages = _cursor.getInt(_cursorIndexOfNoOfUnreadMessages);
            final String _tmpDisplayName;
            if (_cursor.isNull(_cursorIndexOfDisplayName)) {
              _tmpDisplayName = null;
            } else {
              _tmpDisplayName = _cursor.getString(_cursorIndexOfDisplayName);
            }
            final String _tmpLastMessageText;
            if (_cursor.isNull(_cursorIndexOfLastMessageText)) {
              _tmpLastMessageText = null;
            } else {
              _tmpLastMessageText = _cursor.getString(_cursorIndexOfLastMessageText);
            }
            final long _tmpLastMessageTime;
            _tmpLastMessageTime = _cursor.getLong(_cursorIndexOfLastMessageTime);
            final MessageType _tmpMessageType;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfMessageType)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfMessageType);
            }
            _tmpMessageType = __messageTypeEnumConverter.toEnum(_tmp);
            final String _tmpLastMessageSenderID;
            if (_cursor.isNull(_cursorIndexOfLastMessageSenderID)) {
              _tmpLastMessageSenderID = null;
            } else {
              _tmpLastMessageSenderID = _cursor.getString(_cursorIndexOfLastMessageSenderID);
            }
            final String _tmpOtherUserId;
            if (_cursor.isNull(_cursorIndexOfOtherUserId)) {
              _tmpOtherUserId = null;
            } else {
              _tmpOtherUserId = _cursor.getString(_cursorIndexOfOtherUserId);
            }
            final String _tmpProfilePhotoPath;
            if (_cursor.isNull(_cursorIndexOfProfilePhotoPath)) {
              _tmpProfilePhotoPath = null;
            } else {
              _tmpProfilePhotoPath = _cursor.getString(_cursorIndexOfProfilePhotoPath);
            }
            final String _tmpOnlineProfilePhotoPath;
            if (_cursor.isNull(_cursorIndexOfOnlineProfilePhotoPath)) {
              _tmpOnlineProfilePhotoPath = null;
            } else {
              _tmpOnlineProfilePhotoPath = _cursor.getString(_cursorIndexOfOnlineProfilePhotoPath);
            }
            _item = new RoomChat(_tmpId,_tmpNo_of_unread_messages,_tmpDisplayName,_tmpLastMessageText,_tmpLastMessageTime,_tmpMessageType,_tmpLastMessageSenderID,_tmpOtherUserId,_tmpProfilePhotoPath,_tmpOnlineProfilePhotoPath);
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
  public List<RoomChat> getAllChats() {
    final String _sql = "SELECT * FROM roomchat";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfNoOfUnreadMessages = CursorUtil.getColumnIndexOrThrow(_cursor, "no_of_unread_messages");
      final int _cursorIndexOfDisplayName = CursorUtil.getColumnIndexOrThrow(_cursor, "displayName");
      final int _cursorIndexOfLastMessageText = CursorUtil.getColumnIndexOrThrow(_cursor, "lastMessageText");
      final int _cursorIndexOfLastMessageTime = CursorUtil.getColumnIndexOrThrow(_cursor, "lastMessageTime");
      final int _cursorIndexOfMessageType = CursorUtil.getColumnIndexOrThrow(_cursor, "messageType");
      final int _cursorIndexOfLastMessageSenderID = CursorUtil.getColumnIndexOrThrow(_cursor, "lastMessageSenderID");
      final int _cursorIndexOfOtherUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "otherUserId");
      final int _cursorIndexOfProfilePhotoPath = CursorUtil.getColumnIndexOrThrow(_cursor, "profilePhotoPath");
      final int _cursorIndexOfOnlineProfilePhotoPath = CursorUtil.getColumnIndexOrThrow(_cursor, "onlineProfilePhotoPath");
      final List<RoomChat> _result = new ArrayList<RoomChat>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final RoomChat _item;
        final String _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getString(_cursorIndexOfId);
        }
        final int _tmpNo_of_unread_messages;
        _tmpNo_of_unread_messages = _cursor.getInt(_cursorIndexOfNoOfUnreadMessages);
        final String _tmpDisplayName;
        if (_cursor.isNull(_cursorIndexOfDisplayName)) {
          _tmpDisplayName = null;
        } else {
          _tmpDisplayName = _cursor.getString(_cursorIndexOfDisplayName);
        }
        final String _tmpLastMessageText;
        if (_cursor.isNull(_cursorIndexOfLastMessageText)) {
          _tmpLastMessageText = null;
        } else {
          _tmpLastMessageText = _cursor.getString(_cursorIndexOfLastMessageText);
        }
        final long _tmpLastMessageTime;
        _tmpLastMessageTime = _cursor.getLong(_cursorIndexOfLastMessageTime);
        final MessageType _tmpMessageType;
        final String _tmp;
        if (_cursor.isNull(_cursorIndexOfMessageType)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getString(_cursorIndexOfMessageType);
        }
        _tmpMessageType = __messageTypeEnumConverter.toEnum(_tmp);
        final String _tmpLastMessageSenderID;
        if (_cursor.isNull(_cursorIndexOfLastMessageSenderID)) {
          _tmpLastMessageSenderID = null;
        } else {
          _tmpLastMessageSenderID = _cursor.getString(_cursorIndexOfLastMessageSenderID);
        }
        final String _tmpOtherUserId;
        if (_cursor.isNull(_cursorIndexOfOtherUserId)) {
          _tmpOtherUserId = null;
        } else {
          _tmpOtherUserId = _cursor.getString(_cursorIndexOfOtherUserId);
        }
        final String _tmpProfilePhotoPath;
        if (_cursor.isNull(_cursorIndexOfProfilePhotoPath)) {
          _tmpProfilePhotoPath = null;
        } else {
          _tmpProfilePhotoPath = _cursor.getString(_cursorIndexOfProfilePhotoPath);
        }
        final String _tmpOnlineProfilePhotoPath;
        if (_cursor.isNull(_cursorIndexOfOnlineProfilePhotoPath)) {
          _tmpOnlineProfilePhotoPath = null;
        } else {
          _tmpOnlineProfilePhotoPath = _cursor.getString(_cursorIndexOfOnlineProfilePhotoPath);
        }
        _item = new RoomChat(_tmpId,_tmpNo_of_unread_messages,_tmpDisplayName,_tmpLastMessageText,_tmpLastMessageTime,_tmpMessageType,_tmpLastMessageSenderID,_tmpOtherUserId,_tmpProfilePhotoPath,_tmpOnlineProfilePhotoPath);
        _result.add(_item);
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
