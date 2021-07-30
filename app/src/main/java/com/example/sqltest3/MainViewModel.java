package com.example.sqltest3;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Room;


import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private AppDatabase db;
    private LiveData<List<Todo>> todos;

    public MainViewModel(@NonNull Application application) {
        super(application);

        db = Room.databaseBuilder(application, AppDatabase.class, "todo-db").build();
        todos = getAll();
    }

    public LiveData<List<Todo>> getTodos() {
        return todos;
    }

    public void setTodos(LiveData<List<Todo>> todos) {
        this.todos = todos;
    }

    public LiveData<List<Todo>> getAll() {
        return db.todoDao().getAll();
    }

    public void insert(Todo todo) {
        new InsertAsyncTask(db.todoDao()).execute(todo);
    }

    public void deleteALl() {
        new DeleteAsyncTask(db.todoDao()).execute();
    }


    private static class InsertAsyncTask extends AsyncTask<Todo, Void, Void> {
        private TodoDao todoDao;

        public InsertAsyncTask(TodoDao todoDao) {
            this.todoDao = todoDao;
        }

        @Override
        protected Void doInBackground(Todo... todos) {
            todoDao.insert(todos[0]);
            return null;

        }
    }

    private static class DeleteAsyncTask extends AsyncTask<Todo, Void, Void> {
        private TodoDao todoDao;

        public DeleteAsyncTask(TodoDao todoDao) {
            this.todoDao = todoDao;
        }

        @Override
        protected Void doInBackground(Todo... todos) {
            todoDao.deleteAll();
            return null;
        }
    }
}
