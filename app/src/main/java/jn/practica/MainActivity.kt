package jn.practica

import android.database.Cursor
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var base:Base
    lateinit var adapter:ArrayAdapter<String>
    var li:ArrayList<String> = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        base=Base(this,"base",null,1)

        mostrar()


    }

    fun agregar(view: View) {

        base.insertarPersona(Persona("nombre","apellido","telefono"))

        li.clear()
        adapter.clear()

        adapter.notifyDataSetChanged()
        mostrar()
    }
    fun mostrar(){
        var c:Cursor=base.getPersonas()
        while(c.moveToNext())
            li.add(c.getString(c.getColumnIndex("nombre")))
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, li)
        lista.adapter= adapter
    }
    fun eliminar(view: View) {

            doAsync() {
                runOnUiThread{
                    base.eliminarTodo()
                    mostrar()
                }

            }.execute()

    }
    fun editar(view: View) {
        doAsync() {
            runOnUiThread{
                algo()
            }

        }.execute()
    }

    fun algo() {
        base.editarAlgo()
        mostrar()
    }
}
