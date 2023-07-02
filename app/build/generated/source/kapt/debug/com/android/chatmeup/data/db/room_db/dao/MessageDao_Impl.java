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
import com.android.chatmeup.data.db.room_db.data.MessageStatus;
import com.android.chatmeup.data.db.room_db.data.MessageStatusEnumConverter;
import com.android.chatmeup.data.db.room_db.entity.RoomMessage;
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
public final class MessageDao_Impl implements MessageDao {
  private final RoomDatabase __db;

  private final EntityDeletionOrUpdateAdapter<RoomMessage> __deletionAdapterOfRoomMessage;

  private final SharedSQLiteStatement __preparedStmtOfDeleteTable;

  private final EntityUpsertionAdapter<RoomMessage> __upsertionAdapterOfRoomMessage;

  private final MessageStatusEnumConverter __messageStatusEnumConverter = new MessageStatusEnumConverter();

  public MessageDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__deletionAdapterOfRoomMessage = new EntityDeletionOrUpdateAdapter<RoomMessage>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `RoomMessage` WHERE `messageID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, RoomMessage value) {
        if (value.getMessageID() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getMessageID());
        }
      }
    };
    this.__preparedStmtOfDeleteTable = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM roommessage";
        return _query;
      }
    };
    this.__upsertionAdapterOfRoomMessage = new EntityUpsertionAdapter<RoomMessage>(new EntityInsertionAdapter<RoomMessage>(__db) {
      @Override
      public String createQuery() {
        return "INSERT INTO `RoomMessage` (`messageID`,`timeStamp`,`messageText`,`messageTime`,`messageType`,`senderID`,`localThumbnailPath`,`serverThumbnailPath`,`localFilePath`,`serverFilePath`,`messageStatus`,`chatID`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, RoomMessage value) {
        if (value.getMessageID() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getMessageID());
        }
        if (value.getTimeStamp() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTimeStamp());
        }
        if (value.getMessageText() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getMessageText());
        }
        stmt.bindLong(4, value.getMessageTime());
        if (value.getMessageType() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getMessageType());
        }
        if (value.getSenderID() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getSenderID());
        }
        if (value.getLocalThumbnailPath() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getLocalThumbnailPath());
        }
        if (value.getServerThumbnailPath() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getServerThumbnailPath());
        }
        if (value.getLocalFilePath() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getLocalFilePath());
        }
        if (value.getServerFilePath() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getServerFilePath());
        }
        final String _tmp = __messageStatusEnumConverter.fromEnum(value.getMessageStatus());
        if (_tmp == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, _tmp);
        }
        if (value.getChatID() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getChatID());
        }
      }
    }, new EntityDeletionOrUpdateAdapter<RoomMessage>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE `RoomMessage` SET `messageID` = ?,`timeStamp` = ?,`messageText` = ?,`messageTime` = ?,`messageType` = ?,`senderID` = ?,`localThumbnailPath` = ?,`serverThumbnailPath` = ?,`localFilePath` = ?,`serverFilePath` = ?,`messageStatus` = ?,`chatID` = ? WHERE `messageID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, RoomMessage value) {
        if (value.getMessageID() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getMessageID());
        }
        if (value.getTimeStamp() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTimeStamp());
        }
        if (value.getMessageText() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getMessageText());
        }
        stmt.bindLong(4, value.getMessageTime());
        if (value.getMessageType() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getMessageType());
        }
        if (value.getSenderID() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getSenderID());
        }
        if (value.getLocalThumbnailPath() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getLocalThumbnailPath());
        }
        if (value.getServerThumbnailPath() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getServerThumbnailPath());
        }
        if (value.getLocalFilePath() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getLocalFilePath());
        }
        if (value.getServerFilePath() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getServerFilePath());
        }
        final String _tmp = __messageStatusEnumConverter.fromEnum(value.getMessageStatus());
        if (_tmp == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, _tmp);
        }
        if (value.getChatID() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getChatID());
        }
        if (value.getMessageID() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getMessageID());
        }
      }
    });
  }

  @Override
  public void deleteMessage(final RoomMessage roomMessage) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfRoomMessage.handle(roomMessage);
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
  public void upsertMessage(final RoomMessage roomMessage) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __upsertionAdapterOfRoomMessage.upsert(roomMessage);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public RoomMessage getMessage(final String messageID) {
    final String _sql = "SELECT * FROM roommessage WHERE ? = messageID";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (messageID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, messageID);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfMessageID = CursorUtil.getColumnIndexOrThrow(_cursor, "messageID");
      final int _cursorIndexOfTimeStamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timeStamp");
      final int _cursorIndexOfMessageText = CursorUtil.getColumnIndexOrThrow(_cursor, "messageText");
      final int _cursorIndexOfMessageTime = CursorUtil.getColumnIndexOrThrow(_cursor, "messageTime");
      final int _cursorIndexOfMessageType = CursorUtil.getColumnIndexOrThrow(_cursor, "messageType");
      final int _cursorIndexOfSenderID = CursorUtil.getColumnIndexOrThrow(_cursor, "senderID");
      final int _cursorIndexOfLocalThumbnailPath = CursorUtil.getColumnIndexOrThrow(_cursor, "localThumbnailPath");
      final int _cursorIndexOfServerThumbnailPath = CursorUtil.getColumnIndexOrThrow(_cursor, "serverThumbnailPath");
      final int _cursorIndexOfLocalFilePath = CursorUtil.getColumnIndexOrThrow(_cursor, "localFilePath");
      final int _cursorIndexOfServerFilePath = CursorUtil.getColumnIndexOrThrow(_cursor, "serverFilePath");
      final int _cursorIndexOfMessageStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "messageStatus");
      final int _cursorIndexOfChatID = CursorUtil.getColumnIndexOrThrow(_cursor, "chatID");
      final RoomMessage _result;
      if(_cursor.moveToFirst()) {
        final String _tmpMessageID;
        if (_cursor.isNull(_cursorIndexOfMessageID)) {
          _tmpMessageID = null;
        } else {
          _tmpMessageID = _cursor.getString(_cursorIndexOfMessageID);
        }
        final String _tmpTimeStamp;
        if (_cursor.isNull(_cursorIndexOfTimeStamp)) {
          _tmpTimeStamp = null;
        } else {
          _tmpTimeStamp = _cursor.getString(_cursorIndexOfTimeStamp);
        }
        final String _tmpMessageText;
        if (_cursor.isNull(_cursorIndexOfMessageText)) {
          _tmpMessageText = null;
        } else {
          _tmpMessageText = _cursor.getString(_cursorIndexOfMessageText);
        }
        final long _tmpMessageTime;
        _tmpMessageTime = _cursor.getLong(_cursorIndexOfMessageTime);
        final String _tmpMessageType;
        if (_cursor.isNull(_cursorIndexOfMessageType)) {
          _tmpMessageType = null;
        } else {
          _tmpMessageType = _cursor.getString(_cursorIndexOfMessageType);
        }
        final String _tmpSenderID;
        if (_cursor.isNull(_cursorIndexOfSenderID)) {
          _tmpSenderID = null;
        } else {
          _tmpSenderID = _cursor.getString(_cursorIndexOfSenderID);
        }
        final String _tmpLocalThumbnailPath;
        if (_cursor.isNull(_cursorIndexOfLocalThumbnailPath)) {
          _tmpLocalThumbnailPath = null;
        } else {
          _tmpLocalThumbnailPath = _cursor.getString(_cursorIndexOfLocalThumbnailPath);
        }
        final String _tmpServerThumbnailPath;
        if (_cursor.isNull(_cursorIndexOfServerThumbnailPath)) {
          _tmpServerThumbnailPath = null;
        } else {
          _tmpServerThumbnailPath = _cursor.getString(_cursorIndexOfServerThumbnailPath);
        }
        final String _tmpLocalFilePath;
        if (_cursor.isNull(_cursorIndexOfLocalFilePath)) {
          _tmpLocalFilePath = null;
        } else {
          _tmpLocalFilePath = _cursor.getString(_cursorIndexOfLocalFilePath);
        }
        final String _tmpServerFilePath;
        if (_cursor.isNull(_cursorIndexOfServerFilePath)) {
          _tmpServerFilePath = null;
        } else {
          _tmpServerFilePath = _cursor.getString(_cursorIndexOfServerFilePath);
        }
        final MessageStatus _tmpMessageStatus;
        final String _tmp;
        if (_cursor.isNull(_cursorIndexOfMessageStatus)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getString(_cursorIndexOfMessageStatus);
        }
        _tmpMessageStatus = __messageStatusEnumConverter.toEnum(_tmp);
        final String _tmpChatID;
        if (_cursor.isNull(_cursorIndexOfChatID)) {
          _tmpChatID = null;
        } else {
          _tmpChatID = _cursor.getString(_cursorIndexOfChatID);
        }
        _result = new RoomMessage(_tmpMessageID,_tmpTimeStamp,_tmpMessageText,_tmpMessageTime,_tmpMessageType,_tmpSenderID,_tmpLocalThumbnailPath,_tmpServerThumbnailPath,_tmpLocalFilePath,_tmpServerFilePath,_tmpMessageStatus,_tmpChatID);
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
  public boolean messageExists(final String messageID) {
    final String _sql = "SELECT EXISTS(SELECT * FROM roommessage WHERE ? = messageID)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (messageID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, messageID);
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
  public boolean messagesExistsInChat(final String chatID) {
    final String _sql = "SELECT EXISTS(SELECT * FROM roommessage WHERE ? = chatID ORDER BY messageTime ASC)";
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
  public Flow<List<RoomMessage>> getMessagesOrderedByTime(final String chatID) {
    final String _sql = "SELECT * FROM roommessage WHERE ? = chatID ORDER BY messageTime ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (chatID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, chatID);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[]{"roommessage"}, new Callable<List<RoomMessage>>() {
      @Override
      public List<RoomMessage> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfMessageID = CursorUtil.getColumnIndexOrThrow(_cursor, "messageID");
          final int _cursorIndexOfTimeStamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timeStamp");
          final int _cursorIndexOfMessageText = CursorUtil.getColumnIndexOrThrow(_cursor, "messageText");
          final int _cursorIndexOfMessageTime = CursorUtil.getColumnIndexOrThrow(_cursor, "messageTime");
          final int _cursorIndexOfMessageType = CursorUtil.getColumnIndexOrThrow(_cursor, "messageType");
          final int _cursorIndexOfSenderID = CursorUtil.getColumnIndexOrThrow(_cursor, "senderID");
          final int _cursorIndexOfLocalThumbnailPath = CursorUtil.getColumnIndexOrThrow(_cursor, "localThumbnailPath");
          final int _cursorIndexOfServerThumbnailPath = CursorUtil.getColumnIndexOrThrow(_cursor, "serverThumbnailPath");
          final int _cursorIndexOfLocalFilePath = CursorUtil.getColumnIndexOrThrow(_cursor, "localFilePath");
          final int _cursorIndexOfServerFilePath = CursorUtil.getColumnIndexOrThrow(_cursor, "serverFilePath");
          final int _cursorIndexOfMessageStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "messageStatus");
          final int _cursorIndexOfChatID = CursorUtil.getColumnIndexOrThrow(_cursor, "chatID");
          final List<RoomMessage> _result = new ArrayList<RoomMessage>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final RoomMessage _item;
            final String _tmpMessageID;
            if (_cursor.isNull(_cursorIndexOfMessageID)) {
              _tmpMessageID = null;
            } else {
              _tmpMessageID = _cursor.getString(_cursorIndexOfMessageID);
            }
            final String _tmpTimeStamp;
            if (_cursor.isNull(_cursorIndexOfTimeStamp)) {
              _tmpTimeStamp = null;
            } else {
              _tmpTimeStamp = _cursor.getString(_cursorIndexOfTimeStamp);
            }
            final String _tmpMessageText;
            if (_cursor.isNull(_cursorIndexOfMessageText)) {
              _tmpMessageText = null;
            } else {
              _tmpMessageText = _cursor.getString(_cursorIndexOfMessageText);
            }
            final long _tmpMessageTime;
            _tmpMessageTime = _cursor.getLong(_cursorIndexOfMessageTime);
            final String _tmpMessageType;
            if (_cursor.isNull(_cursorIndexOfMessageType)) {
              _tmpMessageType = null;
            } else {
              _tmpMessageType = _cursor.getString(_cursorIndexOfMessageType);
            }
            final String _tmpSenderID;
            if (_cursor.isNull(_cursorIndexOfSenderID)) {
              _tmpSenderID = null;
            } else {
              _tmpSenderID = _cursor.getString(_cursorIndexOfSenderID);
            }
            final String _tmpLocalThumbnailPath;
            if (_cursor.isNull(_cursorIndexOfLocalThumbnailPath)) {
              _tmpLocalThumbnailPath = null;
            } else {
              _tmpLocalThumbnailPath = _cursor.getString(_cursorIndexOfLocalThumbnailPath);
            }
            final String _tmpServerThumbnailPath;
            if (_cursor.isNull(_cursorIndexOfServerThumbnailPath)) {
              _tmpServerThumbnailPath = null;
            } else {
              _tmpServerThumbnailPath = _cursor.getString(_cursorIndexOfServerThumbnailPath);
            }
            final String _tmpLocalFilePath;
            if (_cursor.isNull(_cursorIndexOfLocalFilePath)) {
              _tmpLocalFilePath = null;
            } else {
              _tmpLocalFilePath = _cursor.getString(_cursorIndexOfLocalFilePath);
            }
            final String _tmpServerFilePath;
            if (_cursor.isNull(_cursorIndexOfServerFilePath)) {
              _tmpServerFilePath = null;
            } else {
              _tmpServerFilePath = _cursor.getString(_cursorIndexOfServerFilePath);
            }
            final MessageStatus _tmpMessageStatus;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfMessageStatus)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfMessageStatus);
            }
            _tmpMessageStatus = __messageStatusEnumConverter.toEnum(_tmp);
            final String _tmpChatID;
            if (_cursor.isNull(_cursorIndexOfChatID)) {
              _tmpChatID = null;
            } else {
              _tmpChatID = _cursor.getString(_cursorIndexOfChatID);
            }
            _item = new RoomMessage(_tmpMessageID,_tmpTimeStamp,_tmpMessageText,_tmpMessageTime,_tmpMessageType,_tmpSenderID,_tmpLocalThumbnailPath,_tmpServerThumbnailPath,_tmpLocalFilePath,_tmpServerFilePath,_tmpMessageStatus,_tmpChatID);
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
  public List<RoomMessage> getAllMessages() {
    final String _sql = "SELECT * FROM roommessage";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfMessageID = CursorUtil.getColumnIndexOrThrow(_cursor, "messageID");
      final int _cursorIndexOfTimeStamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timeStamp");
      final int _cursorIndexOfMessageText = CursorUtil.getColumnIndexOrThrow(_cursor, "messageText");
      final int _cursorIndexOfMessageTime = CursorUtil.getColumnIndexOrThrow(_cursor, "messageTime");
      final int _cursorIndexOfMessageType = CursorUtil.getColumnIndexOrThrow(_cursor, "messageType");
      final int _cursorIndexOfSenderID = CursorUtil.getColumnIndexOrThrow(_cursor, "senderID");
      final int _cursorIndexOfLocalThumbnailPath = CursorUtil.getColumnIndexOrThrow(_cursor, "localThumbnailPath");
      final int _cursorIndexOfServerThumbnailPath = CursorUtil.getColumnIndexOrThrow(_cursor, "serverThumbnailPath");
      final int _cursorIndexOfLocalFilePath = CursorUtil.getColumnIndexOrThrow(_cursor, "localFilePath");
      final int _cursorIndexOfServerFilePath = CursorUtil.getColumnIndexOrThrow(_cursor, "serverFilePath");
      final int _cursorIndexOfMessageStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "messageStatus");
      final int _cursorIndexOfChatID = CursorUtil.getColumnIndexOrThrow(_cursor, "chatID");
      final List<RoomMessage> _result = new ArrayList<RoomMessage>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final RoomMessage _item;
        final String _tmpMessageID;
        if (_cursor.isNull(_cursorIndexOfMessageID)) {
          _tmpMessageID = null;
        } else {
          _tmpMessageID = _cursor.getString(_cursorIndexOfMessageID);
        }
        final String _tmpTimeStamp;
        if (_cursor.isNull(_cursorIndexOfTimeStamp)) {
          _tmpTimeStamp = null;
        } else {
          _tmpTimeStamp = _cursor.getString(_cursorIndexOfTimeStamp);
        }
        final String _tmpMessageText;
        if (_cursor.isNull(_cursorIndexOfMessageText)) {
          _tmpMessageText = null;
        } else {
          _tmpMessageText = _cursor.getString(_cursorIndexOfMessageText);
        }
        final long _tmpMessageTime;
        _tmpMessageTime = _cursor.getLong(_cursorIndexOfMessageTime);
        final String _tmpMessageType;
        if (_cursor.isNull(_cursorIndexOfMessageType)) {
          _tmpMessageType = null;
        } else {
          _tmpMessageType = _cursor.getString(_cursorIndexOfMessageType);
        }
        final String _tmpSenderID;
        if (_cursor.isNull(_cursorIndexOfSenderID)) {
          _tmpSenderID = null;
        } else {
          _tmpSenderID = _cursor.getString(_cursorIndexOfSenderID);
        }
        final String _tmpLocalThumbnailPath;
        if (_cursor.isNull(_cursorIndexOfLocalThumbnailPath)) {
          _tmpLocalThumbnailPath = null;
        } else {
          _tmpLocalThumbnailPath = _cursor.getString(_cursorIndexOfLocalThumbnailPath);
        }
        final String _tmpServerThumbnailPath;
        if (_cursor.isNull(_cursorIndexOfServerThumbnailPath)) {
          _tmpServerThumbnailPath = null;
        } else {
          _tmpServerThumbnailPath = _cursor.getString(_cursorIndexOfServerThumbnailPath);
        }
        final String _tmpLocalFilePath;
        if (_cursor.isNull(_cursorIndexOfLocalFilePath)) {
          _tmpLocalFilePath = null;
        } else {
          _tmpLocalFilePath = _cursor.getString(_cursorIndexOfLocalFilePath);
        }
        final String _tmpServerFilePath;
        if (_cursor.isNull(_cursorIndexOfServerFilePath)) {
          _tmpServerFilePath = null;
        } else {
          _tmpServerFilePath = _cursor.getString(_cursorIndexOfServerFilePath);
        }
        final MessageStatus _tmpMessageStatus;
        final String _tmp;
        if (_cursor.isNull(_cursorIndexOfMessageStatus)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getString(_cursorIndexOfMessageStatus);
        }
        _tmpMessageStatus = __messageStatusEnumConverter.toEnum(_tmp);
        final String _tmpChatID;
        if (_cursor.isNull(_cursorIndexOfChatID)) {
          _tmpChatID = null;
        } else {
          _tmpChatID = _cursor.getString(_cursorIndexOfChatID);
        }
        _item = new RoomMessage(_tmpMessageID,_tmpTimeStamp,_tmpMessageText,_tmpMessageTime,_tmpMessageType,_tmpSenderID,_tmpLocalThumbnailPath,_tmpServerThumbnailPath,_tmpLocalFilePath,_tmpServerFilePath,_tmpMessageStatus,_tmpChatID);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Flow<RoomMessage> getLastMessage(final String chatID) {
    final String _sql = "SELECT * FROM roommessage WHERE ? = chatID ORDER BY messageTime ASC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (chatID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, chatID);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[]{"roommessage"}, new Callable<RoomMessage>() {
      @Override
      public RoomMessage call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfMessageID = CursorUtil.getColumnIndexOrThrow(_cursor, "messageID");
          final int _cursorIndexOfTimeStamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timeStamp");
          final int _cursorIndexOfMessageText = CursorUtil.getColumnIndexOrThrow(_cursor, "messageText");
          final int _cursorIndexOfMessageTime = CursorUtil.getColumnIndexOrThrow(_cursor, "messageTime");
          final int _cursorIndexOfMessageType = CursorUtil.getColumnIndexOrThrow(_cursor, "messageType");
          final int _cursorIndexOfSenderID = CursorUtil.getColumnIndexOrThrow(_cursor, "senderID");
          final int _cursorIndexOfLocalThumbnailPath = CursorUtil.getColumnIndexOrThrow(_cursor, "localThumbnailPath");
          final int _cursorIndexOfServerThumbnailPath = CursorUtil.getColumnIndexOrThrow(_cursor, "serverThumbnailPath");
          final int _cursorIndexOfLocalFilePath = CursorUtil.getColumnIndexOrThrow(_cursor, "localFilePath");
          final int _cursorIndexOfServerFilePath = CursorUtil.getColumnIndexOrThrow(_cursor, "serverFilePath");
          final int _cursorIndexOfMessageStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "messageStatus");
          final int _cursorIndexOfChatID = CursorUtil.getColumnIndexOrThrow(_cursor, "chatID");
          final RoomMessage _result;
          if(_cursor.moveToFirst()) {
            final String _tmpMessageID;
            if (_cursor.isNull(_cursorIndexOfMessageID)) {
              _tmpMessageID = null;
            } else {
              _tmpMessageID = _cursor.getString(_cursorIndexOfMessageID);
            }
            final String _tmpTimeStamp;
            if (_cursor.isNull(_cursorIndexOfTimeStamp)) {
              _tmpTimeStamp = null;
            } else {
              _tmpTimeStamp = _cursor.getString(_cursorIndexOfTimeStamp);
            }
            final String _tmpMessageText;
            if (_cursor.isNull(_cursorIndexOfMessageText)) {
              _tmpMessageText = null;
            } else {
              _tmpMessageText = _cursor.getString(_cursorIndexOfMessageText);
            }
            final long _tmpMessageTime;
            _tmpMessageTime = _cursor.getLong(_cursorIndexOfMessageTime);
            final String _tmpMessageType;
            if (_cursor.isNull(_cursorIndexOfMessageType)) {
              _tmpMessageType = null;
            } else {
              _tmpMessageType = _cursor.getString(_cursorIndexOfMessageType);
            }
            final String _tmpSenderID;
            if (_cursor.isNull(_cursorIndexOfSenderID)) {
              _tmpSenderID = null;
            } else {
              _tmpSenderID = _cursor.getString(_cursorIndexOfSenderID);
            }
            final String _tmpLocalThumbnailPath;
            if (_cursor.isNull(_cursorIndexOfLocalThumbnailPath)) {
              _tmpLocalThumbnailPath = null;
            } else {
              _tmpLocalThumbnailPath = _cursor.getString(_cursorIndexOfLocalThumbnailPath);
            }
            final String _tmpServerThumbnailPath;
            if (_cursor.isNull(_cursorIndexOfServerThumbnailPath)) {
              _tmpServerThumbnailPath = null;
            } else {
              _tmpServerThumbnailPath = _cursor.getString(_cursorIndexOfServerThumbnailPath);
            }
            final String _tmpLocalFilePath;
            if (_cursor.isNull(_cursorIndexOfLocalFilePath)) {
              _tmpLocalFilePath = null;
            } else {
              _tmpLocalFilePath = _cursor.getString(_cursorIndexOfLocalFilePath);
            }
            final String _tmpServerFilePath;
            if (_cursor.isNull(_cursorIndexOfServerFilePath)) {
              _tmpServerFilePath = null;
            } else {
              _tmpServerFilePath = _cursor.getString(_cursorIndexOfServerFilePath);
            }
            final MessageStatus _tmpMessageStatus;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfMessageStatus)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfMessageStatus);
            }
            _tmpMessageStatus = __messageStatusEnumConverter.toEnum(_tmp);
            final String _tmpChatID;
            if (_cursor.isNull(_cursorIndexOfChatID)) {
              _tmpChatID = null;
            } else {
              _tmpChatID = _cursor.getString(_cursorIndexOfChatID);
            }
            _result = new RoomMessage(_tmpMessageID,_tmpTimeStamp,_tmpMessageText,_tmpMessageTime,_tmpMessageType,_tmpSenderID,_tmpLocalThumbnailPath,_tmpServerThumbnailPath,_tmpLocalFilePath,_tmpServerFilePath,_tmpMessageStatus,_tmpChatID);
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
  public Flow<List<RoomMessage>> searchMessagesOrderedByTime(final String searchText) {
    final String _sql = "SELECT * FROM roommessage WHERE messageText LIKE ? ORDER BY messageTime DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (searchText == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, searchText);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[]{"roommessage"}, new Callable<List<RoomMessage>>() {
      @Override
      public List<RoomMessage> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfMessageID = CursorUtil.getColumnIndexOrThrow(_cursor, "messageID");
          final int _cursorIndexOfTimeStamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timeStamp");
          final int _cursorIndexOfMessageText = CursorUtil.getColumnIndexOrThrow(_cursor, "messageText");
          final int _cursorIndexOfMessageTime = CursorUtil.getColumnIndexOrThrow(_cursor, "messageTime");
          final int _cursorIndexOfMessageType = CursorUtil.getColumnIndexOrThrow(_cursor, "messageType");
          final int _cursorIndexOfSenderID = CursorUtil.getColumnIndexOrThrow(_cursor, "senderID");
          final int _cursorIndexOfLocalThumbnailPath = CursorUtil.getColumnIndexOrThrow(_cursor, "localThumbnailPath");
          final int _cursorIndexOfServerThumbnailPath = CursorUtil.getColumnIndexOrThrow(_cursor, "serverThumbnailPath");
          final int _cursorIndexOfLocalFilePath = CursorUtil.getColumnIndexOrThrow(_cursor, "localFilePath");
          final int _cursorIndexOfServerFilePath = CursorUtil.getColumnIndexOrThrow(_cursor, "serverFilePath");
          final int _cursorIndexOfMessageStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "messageStatus");
          final int _cursorIndexOfChatID = CursorUtil.getColumnIndexOrThrow(_cursor, "chatID");
          final List<RoomMessage> _result = new ArrayList<RoomMessage>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final RoomMessage _item;
            final String _tmpMessageID;
            if (_cursor.isNull(_cursorIndexOfMessageID)) {
              _tmpMessageID = null;
            } else {
              _tmpMessageID = _cursor.getString(_cursorIndexOfMessageID);
            }
            final String _tmpTimeStamp;
            if (_cursor.isNull(_cursorIndexOfTimeStamp)) {
              _tmpTimeStamp = null;
            } else {
              _tmpTimeStamp = _cursor.getString(_cursorIndexOfTimeStamp);
            }
            final String _tmpMessageText;
            if (_cursor.isNull(_cursorIndexOfMessageText)) {
              _tmpMessageText = null;
            } else {
              _tmpMessageText = _cursor.getString(_cursorIndexOfMessageText);
            }
            final long _tmpMessageTime;
            _tmpMessageTime = _cursor.getLong(_cursorIndexOfMessageTime);
            final String _tmpMessageType;
            if (_cursor.isNull(_cursorIndexOfMessageType)) {
              _tmpMessageType = null;
            } else {
              _tmpMessageType = _cursor.getString(_cursorIndexOfMessageType);
            }
            final String _tmpSenderID;
            if (_cursor.isNull(_cursorIndexOfSenderID)) {
              _tmpSenderID = null;
            } else {
              _tmpSenderID = _cursor.getString(_cursorIndexOfSenderID);
            }
            final String _tmpLocalThumbnailPath;
            if (_cursor.isNull(_cursorIndexOfLocalThumbnailPath)) {
              _tmpLocalThumbnailPath = null;
            } else {
              _tmpLocalThumbnailPath = _cursor.getString(_cursorIndexOfLocalThumbnailPath);
            }
            final String _tmpServerThumbnailPath;
            if (_cursor.isNull(_cursorIndexOfServerThumbnailPath)) {
              _tmpServerThumbnailPath = null;
            } else {
              _tmpServerThumbnailPath = _cursor.getString(_cursorIndexOfServerThumbnailPath);
            }
            final String _tmpLocalFilePath;
            if (_cursor.isNull(_cursorIndexOfLocalFilePath)) {
              _tmpLocalFilePath = null;
            } else {
              _tmpLocalFilePath = _cursor.getString(_cursorIndexOfLocalFilePath);
            }
            final String _tmpServerFilePath;
            if (_cursor.isNull(_cursorIndexOfServerFilePath)) {
              _tmpServerFilePath = null;
            } else {
              _tmpServerFilePath = _cursor.getString(_cursorIndexOfServerFilePath);
            }
            final MessageStatus _tmpMessageStatus;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfMessageStatus)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfMessageStatus);
            }
            _tmpMessageStatus = __messageStatusEnumConverter.toEnum(_tmp);
            final String _tmpChatID;
            if (_cursor.isNull(_cursorIndexOfChatID)) {
              _tmpChatID = null;
            } else {
              _tmpChatID = _cursor.getString(_cursorIndexOfChatID);
            }
            _item = new RoomMessage(_tmpMessageID,_tmpTimeStamp,_tmpMessageText,_tmpMessageTime,_tmpMessageType,_tmpSenderID,_tmpLocalThumbnailPath,_tmpServerThumbnailPath,_tmpLocalFilePath,_tmpServerFilePath,_tmpMessageStatus,_tmpChatID);
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
