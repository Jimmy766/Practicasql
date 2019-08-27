package jn.practica

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper




class Base(context: Context, name: String, factory: SQLiteDatabase.CursorFactory?=null, version: Int) :
    SQLiteOpenHelper(context, name, factory, version) {


    override fun onCreate(db: SQLiteDatabase) {
        crearTablas(db)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

    }
    public fun crearTablas(db: SQLiteDatabase){
     db.execSQL(
         "CREATE TABLE  Persona ("
                 +"id INTEGER PRIMARY KEY AUTOINCREMENT,"
                 + "nombre TEXT NOT NULL,"
                 + "apellido TEXT NOT NULL,"
                 + "telefono TEXT NOT NULL,"

                 + "UNIQUE (id))"
     )

    }
    public fun insertarPersona(p:Persona): Long {
        var c:ContentValues= ContentValues()
        c.put("nombre",p.nombre)
        c.put("apellido",p.apellido)
        c.put("telefono",p.telefono)

        return writableDatabase.insert("Persona",null,c)
    }
   public  fun getPersonas(): Cursor {
        return writableDatabase.query("Persona",
            null,
            null,
            null,
            null,
            null,
            null)
    }
    public fun eliminarTodo():Int{
        var a=  arrayOf("nombre")

        return writableDatabase.delete("Persona","nombre LIKE ?",a)
    }
    public  fun editarAlgo():Int{
        var c:ContentValues= ContentValues()
        var a=  arrayOf("nombre")
        c.put("nombre","actualizado")
        var s:Int= writableDatabase.update("Persona",c,"nombre LIKE ?",a)
        return s;
    }

}
