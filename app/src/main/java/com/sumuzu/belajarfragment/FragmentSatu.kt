package com.sumuzu.belajarfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sumuzu.belajarfragment.databinding.FragmentSatuBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentSatu.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentSatu : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

//    lateinit var binding : FragmentSatuBinding

    private var _binding: FragmentSatuBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_satu, container, false)

        _binding = FragmentSatuBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }


    //berhubungan dgn layout (btn dll)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragmentDua = FragmentDua()

        binding.btnDua.setOnClickListener {
            val bundle = Bundle()
            bundle.putString(FragmentDua.EXTRA_NAME, "data dari fragment satu")

            val desc = "Fragment ini akan menerima data dari FRAGMENT SATU"
            fragmentDua.arguments = bundle
            fragmentDua.desc = desc

            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.container, fragmentDua, FragmentDua::class.java.simpleName)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentSatu.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentSatu().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}