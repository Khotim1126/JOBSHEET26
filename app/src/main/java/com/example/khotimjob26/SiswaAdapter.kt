package layout

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.khotimjob26.EditActivity
import com.example.khotimjob26.R
import java.text.FieldPosition

class SiswaAdapter(private val data: ArrayList<Siswa>?): RecyclerView.Adapter<SiswaAdapter.SiswaViewHolder>() {

    class SiswaViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val judul = itemView.findViewById<TextView>(R.id.judulSiswa)
        private val isi = itemView.findViewById<TextView>(R.id.isiSiswa)
        private val editBtn = itemView.findViewById<Button>(R.id.btnEdit)
        private val hapusBtn = itemView.findViewById<Button>(R.id.btnHapus)
        fun bind(get: Siswa) {
            judul.text = get.judul
            isi.text = get.isi

            editBtn.setOnClickListener() {
                val intent = Intent(itemView.context, EditActivity::class.java)
                intent.putExtra("id", get.id)
                intent.putExtra("judul", get.judul)
                intent.putExtra("isi", get.isi)
                itemView.context.startActivity(intent)
            }

            hapusBtn.setOnClickListener() {
                val dialogBuilder = AlertDialog.Builder(itemView.context)
                dialogBuilder.setTitle("Hapus Data")
                dialogBuilder.setMessage("Hapus Siswa")
                dialogBuilder.setPositiveButton("Delete", DialogInterface.OnClickListener { _, _ ->
                    val db = DBHelper(itemView.context, null)
                    val status = db.deleteSiswa(get.id)
                    if (status > -1) Toast.makeText(itemView.context, "data dihapus",Toast.LENGTH_LONG).show()
                })
                dialogBuilder.setNegativeButton("Cancel", DialogInterface.OnClickListener { _, _ ->

                })
                dialogBuilder.create()
                dialogBuilder.show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SiswaViewHolder {
        return SiswaViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.activity_list, parent, false))
    }

    everride fun onBindViewHolder(holder: SiswaViewHolder, position: Int) {
        holder.bind(data?.get(position) ?: Siswa( "", "", ""))
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }
}