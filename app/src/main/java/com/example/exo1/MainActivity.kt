package com.example.exo1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var wordList = arrayListOf<Word>()

    lateinit var adapter: WordAdapter
    lateinit var layoutManager : LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        adapter = WordAdapter(this)
        recyclerView.adapter = adapter

        initData()
    }

    fun initData(){
        val word1 = Word("Développement", "Mise au point d'un appareil, d'un produit en vue de sa vente", false, R.drawable.developpement, 0, R.raw.developpement)
        val word2 = Word("Application", "Action de mettre une chose sur une autre de manière qu'elle la recouvre et y adhère.", true,R.drawable.application,  R.raw.video_application, R.raw.application)
        val word3 = Word("Dictionnaire", "Recueil contenant des mots, des expressions d'une langue, présentés dans un ordre convenu, et qui donne des définitions, des informations sur eux.", true, R.drawable.dictionnaire,R.raw.video_dictionnaire,  R.raw.dictionnaire)
        val word4 = Word("Travail", "Ensemble des activités humaines organisées, coordonnées en vue de produire ce qui est utile", false, R.drawable.travail, 0, R.raw.travail)
        val word5 = Word("Enseignement", "Action, art d'enseigner, de transmettre des connaissances.", false, R.drawable.enseignement,0, R.raw.enseignement)
        val word6 = Word("Apprentissage", "Fait d'apprendre un métier manuel ou technique", false, R.drawable.apprentissage,0, R.raw.apprentissage)

        wordList.add(word1)
        wordList.add(word2)
        wordList.add(word3)
        wordList.add(word4)
        wordList.add(word5)
        wordList.add(word6)

        adapter.notifyDataSetChanged()


    }

    class WordAdapter(val activity : MainActivity) : RecyclerView.Adapter<WordAdapter.WordViewHolder>(){
        class WordViewHolder(v : View) : RecyclerView.ViewHolder(v){
            val wordView = v.findViewById<TextView>(R.id.wordTitleView)
            val itemLayout = v.findViewById<RelativeLayout>(R.id.itemLayout)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
            return WordViewHolder(LayoutInflater.from(activity).inflate(R.layout.item_layout, parent, false))
        }

        override fun getItemCount(): Int {
            return activity.wordList.size
        }

        override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
            val word = activity.wordList[position]
            holder.wordView.text = word.title


            holder.itemLayout.setOnClickListener {
                val intent = Intent(activity, DefinitionActivity::class.java)
                intent.putExtra("word", word)
                activity.startActivity(intent)
            }
        }
    }
}
