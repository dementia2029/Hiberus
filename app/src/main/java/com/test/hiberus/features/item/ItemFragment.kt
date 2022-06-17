package com.test.hiberus.features.item

import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.test.hiberus.R
import com.test.hiberus.databinding.FragmentItemBinding
import com.test.hiberus.utils.GlideApp
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ItemFragment : Fragment(R.layout.fragment_item) {

    private val args: ItemFragmentArgs by navArgs()
    @Inject
    lateinit var assistedFactory: ItemViewModel.AssistedViewModelFactory
    private var _binding: FragmentItemBinding? = null
    private val binding get() = _binding!!

    private val viewModel :ItemViewModel by viewModels {
        ItemViewModel.provideFactory(
            assistedFactory,this, null, args.id
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentItemBinding.bind(view)

        viewModel.cardData.observe(viewLifecycleOwner){
            GlideApp
                .with(requireContext())
                .load(it.imageUrl)
                .placeholder(ColorDrawable(requireContext().getColor(R.color.purple_200)))
                .into(binding.img)

            binding.textview.text = it.name
            binding.textViewDesc.text = it.desc
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}