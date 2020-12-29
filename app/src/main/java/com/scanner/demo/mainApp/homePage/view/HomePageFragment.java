package com.scanner.demo.mainApp.homePage.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.scanner.demo.mainApp.homePage.adapter.ReceiveLetterCustomAdapter;
import com.scanner.demo.mainApp.homePage.model.ReceiveLetterRoot;
import com.scanner.demo.mainApp.homePage.viewmodel.ReceiveLetterVM;
import com.scanner.demo.R;
import com.scanner.demo.databinding.FragmentHomePageBinding;

public class HomePageFragment extends Fragment {
    FragmentHomePageBinding fragmentHomePageBinding;
    ReceiveLetterVM receiveLetterVM;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentHomePageBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_home_page,container,false);
        return fragmentHomePageBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        receiveLetterVM = new ReceiveLetterVM(getContext());
        MutableLiveData<ReceiveLetterRoot> mutableLiveData = receiveLetterVM.getReceiveLetterRootMutableLiveData();
        mutableLiveData.observe(getActivity(), new Observer<ReceiveLetterRoot>() {
            @Override
            public void onChanged(ReceiveLetterRoot receiveLetterRoot) {
                receiveLetterVM.setData(receiveLetterRoot.getData());
                receiveLetterVM.setMessage(receiveLetterRoot.getMessage());
                fragmentHomePageBinding.setReceiveLetterVM(receiveLetterVM);
                Toast.makeText(getContext(), receiveLetterRoot.getData().getTotalResults() + "", Toast.LENGTH_SHORT).show();
                fragmentHomePageBinding.setReceiveLetterVM(receiveLetterVM);
                fragmentHomePageBinding.recyReceiveLetter.setAdapter(new ReceiveLetterCustomAdapter(receiveLetterRoot.getData().getList(),getContext()));
            }
        });
    }
}