package my.edu.tarc.carloan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import my.edu.tarc.carloan.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //TODO 4: CREATE AN INSTANCE OF DATA BINDING

       /* _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root*/
        _binding = DataBindingUtil.inflate(inflater,R.layout.fragment_second,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //TODO 5:Create an instance of data class
        val interestData= InterestData( "CIMB\nMaybank\nPublic Bank\n",  "2.95%(p.a)\n3.01%(p.a)\n3.05\n3.15%(p.a)")
//TODO 6:Link data class to layout
        binding.bankInterestRate=interestData

        //binding.textView.text = interestData.bank
        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}