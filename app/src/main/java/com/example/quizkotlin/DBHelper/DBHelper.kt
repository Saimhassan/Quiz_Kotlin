package com.example.quizkotlin.DBHelper

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.quizkotlin.Model.Category
import com.example.quizkotlin.Model.Question
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper
import okhttp3.internal.Internal.instance

class DBHelper(context:Context):SQLiteAssetHelper(context,DB_NAME,null,DB_VER) {
    companion object{
        private var instance:DBHelper?=null
        private val DB_NAME = "SaimQuiz2020.db"
        private val DB_VER = 1


        @Synchronized
        fun getInstance(context: Context):DBHelper
        {
          if (instance == null)
              instance = DBHelper(context)
            return instance!!
        }
    }


    //Get All Category

    val allCategories:MutableList<Category>
    get(){
        val db = instance!!.writableDatabase
        val cursor = db.rawQuery("SELECT * FROM Category",null)
        val categories = ArrayList<Category>()
        if (cursor.moveToFirst())
        {
            while (!cursor.isAfterLast)
            {
                val category = Category(cursor.getInt(cursor.getColumnIndex("ID")),
                    cursor.getString(cursor.getColumnIndex("Name")),
                    cursor.getString(cursor.getColumnIndex("Image")))
                categories.add(category)
                cursor.moveToNext()
            }
        }
        cursor.close()
        db.close()
        return categories
    }

    //Get All Questions by Category
    fun getQuestionByCategory(categoryId:Int):MutableList<Question>{
        val db = instance!!.writableDatabase
        val cursor = db.rawQuery("SELECT * FROM Question WHERE categoryId=$categoryId ORDER BY RANDOM() LIMIT 30",null)
        val questionList = ArrayList<Question>()
        if (cursor.moveToFirst())
        {
            while (!cursor.isAfterLast)
            {
                val question = Question(cursor.getInt(cursor.getColumnIndex("ID")),
                    cursor.getString(cursor.getColumnIndex("QuestionIndex")),
                    cursor.getString(cursor.getColumnIndex("QuestionImage")),
                    cursor.getString(cursor.getColumnIndex("AnswerA")),
                    cursor.getString(cursor.getColumnIndex("AnswerB")),
                    cursor.getString(cursor.getColumnIndex("AnswerC")),
                    cursor.getString(cursor.getColumnIndex("AnswerD")),
                    cursor.getString(cursor.getColumnIndex("CorrectAnswer")),
                    if (cursor.getInt(cursor.getColumnIndex("IsImageQuestion")) == 0) java.lang.Boolean.FALSE else java.lang.Boolean.TRUE,
                    cursor.getInt(cursor.getColumnIndex("CategoryID"))
                    )
                questionList.add(question)
                cursor.moveToNext()
            }
        }
        cursor.close()
        db.close()
        return questionList
    }

}