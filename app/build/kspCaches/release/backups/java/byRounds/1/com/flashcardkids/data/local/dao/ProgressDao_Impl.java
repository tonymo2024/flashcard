package com.flashcardkids.data.local.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.flashcardkids.data.local.entity.ProgressEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class ProgressDao_Impl implements ProgressDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ProgressEntity> __insertionAdapterOfProgressEntity;

  private final EntityDeletionOrUpdateAdapter<ProgressEntity> __updateAdapterOfProgressEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteProgressByCardId;

  public ProgressDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfProgressEntity = new EntityInsertionAdapter<ProgressEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `progress` (`id`,`cardId`,`correctCount`,`incorrectCount`,`lastStudied`,`mastered`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ProgressEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getCardId());
        statement.bindLong(3, entity.getCorrectCount());
        statement.bindLong(4, entity.getIncorrectCount());
        statement.bindLong(5, entity.getLastStudied());
        final int _tmp = entity.getMastered() ? 1 : 0;
        statement.bindLong(6, _tmp);
      }
    };
    this.__updateAdapterOfProgressEntity = new EntityDeletionOrUpdateAdapter<ProgressEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `progress` SET `id` = ?,`cardId` = ?,`correctCount` = ?,`incorrectCount` = ?,`lastStudied` = ?,`mastered` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ProgressEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getCardId());
        statement.bindLong(3, entity.getCorrectCount());
        statement.bindLong(4, entity.getIncorrectCount());
        statement.bindLong(5, entity.getLastStudied());
        final int _tmp = entity.getMastered() ? 1 : 0;
        statement.bindLong(6, _tmp);
        statement.bindLong(7, entity.getId());
      }
    };
    this.__preparedStmtOfDeleteProgressByCardId = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM progress WHERE cardId = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertProgress(final ProgressEntity progress,
      final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfProgressEntity.insertAndReturnId(progress);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateProgress(final ProgressEntity progress,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfProgressEntity.handle(progress);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteProgressByCardId(final long cardId,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteProgressByCardId.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, cardId);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteProgressByCardId.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object getProgressByCardId(final long cardId,
      final Continuation<? super ProgressEntity> $completion) {
    final String _sql = "SELECT * FROM progress WHERE cardId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, cardId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<ProgressEntity>() {
      @Override
      @Nullable
      public ProgressEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCardId = CursorUtil.getColumnIndexOrThrow(_cursor, "cardId");
          final int _cursorIndexOfCorrectCount = CursorUtil.getColumnIndexOrThrow(_cursor, "correctCount");
          final int _cursorIndexOfIncorrectCount = CursorUtil.getColumnIndexOrThrow(_cursor, "incorrectCount");
          final int _cursorIndexOfLastStudied = CursorUtil.getColumnIndexOrThrow(_cursor, "lastStudied");
          final int _cursorIndexOfMastered = CursorUtil.getColumnIndexOrThrow(_cursor, "mastered");
          final ProgressEntity _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpCardId;
            _tmpCardId = _cursor.getLong(_cursorIndexOfCardId);
            final int _tmpCorrectCount;
            _tmpCorrectCount = _cursor.getInt(_cursorIndexOfCorrectCount);
            final int _tmpIncorrectCount;
            _tmpIncorrectCount = _cursor.getInt(_cursorIndexOfIncorrectCount);
            final long _tmpLastStudied;
            _tmpLastStudied = _cursor.getLong(_cursorIndexOfLastStudied);
            final boolean _tmpMastered;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfMastered);
            _tmpMastered = _tmp != 0;
            _result = new ProgressEntity(_tmpId,_tmpCardId,_tmpCorrectCount,_tmpIncorrectCount,_tmpLastStudied,_tmpMastered);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<ProgressEntity>> getAllProgress() {
    final String _sql = "SELECT * FROM progress";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"progress"}, new Callable<List<ProgressEntity>>() {
      @Override
      @NonNull
      public List<ProgressEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCardId = CursorUtil.getColumnIndexOrThrow(_cursor, "cardId");
          final int _cursorIndexOfCorrectCount = CursorUtil.getColumnIndexOrThrow(_cursor, "correctCount");
          final int _cursorIndexOfIncorrectCount = CursorUtil.getColumnIndexOrThrow(_cursor, "incorrectCount");
          final int _cursorIndexOfLastStudied = CursorUtil.getColumnIndexOrThrow(_cursor, "lastStudied");
          final int _cursorIndexOfMastered = CursorUtil.getColumnIndexOrThrow(_cursor, "mastered");
          final List<ProgressEntity> _result = new ArrayList<ProgressEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final ProgressEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpCardId;
            _tmpCardId = _cursor.getLong(_cursorIndexOfCardId);
            final int _tmpCorrectCount;
            _tmpCorrectCount = _cursor.getInt(_cursorIndexOfCorrectCount);
            final int _tmpIncorrectCount;
            _tmpIncorrectCount = _cursor.getInt(_cursorIndexOfIncorrectCount);
            final long _tmpLastStudied;
            _tmpLastStudied = _cursor.getLong(_cursorIndexOfLastStudied);
            final boolean _tmpMastered;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfMastered);
            _tmpMastered = _tmp != 0;
            _item = new ProgressEntity(_tmpId,_tmpCardId,_tmpCorrectCount,_tmpIncorrectCount,_tmpLastStudied,_tmpMastered);
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
  public Flow<List<ProgressEntity>> getProgressByDeckId(final long deckId) {
    final String _sql = "\n"
            + "        SELECT p.* FROM progress p \n"
            + "        INNER JOIN cards c ON p.cardId = c.id \n"
            + "        WHERE c.deckId = ?\n"
            + "    ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, deckId);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"progress",
        "cards"}, new Callable<List<ProgressEntity>>() {
      @Override
      @NonNull
      public List<ProgressEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCardId = CursorUtil.getColumnIndexOrThrow(_cursor, "cardId");
          final int _cursorIndexOfCorrectCount = CursorUtil.getColumnIndexOrThrow(_cursor, "correctCount");
          final int _cursorIndexOfIncorrectCount = CursorUtil.getColumnIndexOrThrow(_cursor, "incorrectCount");
          final int _cursorIndexOfLastStudied = CursorUtil.getColumnIndexOrThrow(_cursor, "lastStudied");
          final int _cursorIndexOfMastered = CursorUtil.getColumnIndexOrThrow(_cursor, "mastered");
          final List<ProgressEntity> _result = new ArrayList<ProgressEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final ProgressEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpCardId;
            _tmpCardId = _cursor.getLong(_cursorIndexOfCardId);
            final int _tmpCorrectCount;
            _tmpCorrectCount = _cursor.getInt(_cursorIndexOfCorrectCount);
            final int _tmpIncorrectCount;
            _tmpIncorrectCount = _cursor.getInt(_cursorIndexOfIncorrectCount);
            final long _tmpLastStudied;
            _tmpLastStudied = _cursor.getLong(_cursorIndexOfLastStudied);
            final boolean _tmpMastered;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfMastered);
            _tmpMastered = _tmp != 0;
            _item = new ProgressEntity(_tmpId,_tmpCardId,_tmpCorrectCount,_tmpIncorrectCount,_tmpLastStudied,_tmpMastered);
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
  public Object getMasteredCount(final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM progress WHERE mastered = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final int _tmp;
            _tmp = _cursor.getInt(0);
            _result = _tmp;
          } else {
            _result = 0;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
