package com.example.lovecalculate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lovecalculate.databinding.FragmentResultBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            RetrofitService.api.getLove(etYou.text.toString(),
                etMe.text.toString())
                .enqueue(object : Callback<LoveModel> {
                    override fun onResponse(
                        call: Call<LoveModel>,
                        response: Response<LoveModel>
                    ) {
                        etYou.text = response.body()?.fname.toString()
                        etMe.text = response.body()?.sname
                        tvPercentage.text = response.body()?.percentage.toString() + "%"
                        tvResult.text = response.body()?.result.toString()
                    }
                    override fun onFailure(
                        call: Call<LoveModel>,
                        t: Throwable
                    ) {
                        tvResult.text = t.message
                    }

                })
        }
    }
}