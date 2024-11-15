package br.com.fiap.alunoresponsavel_rm95849

import android.graphics.Rect
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.SearchView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.alunoresponsavel_rm95849.data.Tip
import br.com.fiap.alunoresponsavel_rm95849.viewmodel.TipAdapter
import br.com.fiap.alunoresponsavel_rm95849.viewmodel.TipViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private lateinit var titleEditText: EditText
    private lateinit var descriptionEditText: EditText
    private lateinit var addButton: Button
    private val tipViewModel: TipViewModel by viewModels()
    private val tipAdapter = TipAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViews()
        setupRecyclerView()
        setupSearchView()
        setupAddButton()
        observeTips()
    }

    private fun setupViews() {
        recyclerView = findViewById(R.id.recyclerView)
        searchView = findViewById(R.id.searchView)
        titleEditText = findViewById(R.id.editTextTitle)
        descriptionEditText = findViewById(R.id.editTextDescription)
        addButton = findViewById(R.id.buttonAdd)
    }

    private fun setupRecyclerView() {
        recyclerView.apply {
            adapter = tipAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true) // Otimização de performance

            // Adiciona espaçamento entre itens
            addItemDecoration(object : RecyclerView.ItemDecoration() {
                override fun getItemOffsets(
                    outRect: Rect,
                    view: View,
                    parent: RecyclerView,
                    state: RecyclerView.State
                ) {
                    val spacing = resources.getDimensionPixelSize(R.dimen.item_margin)
                    outRect.apply {
                        left = spacing
                        right = spacing
                        top = spacing
                        // Adiciona margem inferior apenas se não for o último item
                        if (parent.getChildAdapterPosition(view) < parent.adapter?.itemCount ?: 0 - 1) {
                            bottom = spacing
                        }
                    }
                }
            })
        }
    }

    private fun setupSearchView() {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { tipViewModel.searchTips(it) }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let { tipViewModel.searchTips(it) }
                return true
            }
        })
    }

    private fun setupAddButton() {
        addButton.setOnClickListener {
            val title = titleEditText.text.toString().trim()
            val description = descriptionEditText.text.toString().trim()

            if (title.isNotEmpty() && description.isNotEmpty()) {
                tipViewModel.insert(Tip(title = title, description = description))
                clearInputs()
                Toast.makeText(this, "Dica adicionada com sucesso!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun clearInputs() {
        titleEditText.text.clear()
        descriptionEditText.text.clear()
        titleEditText.clearFocus()
        descriptionEditText.clearFocus()
    }

    private fun observeTips() {
        tipViewModel.allTips.observe(this) { tips ->
            tipAdapter.setTips(tips)
        }

        tipViewModel.searchResults.observe(this) { tips ->
            tipAdapter.setTips(tips)
        }
    }
}