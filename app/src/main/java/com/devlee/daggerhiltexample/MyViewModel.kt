package com.devlee.daggerhiltexample

import androidx.lifecycle.ViewModel
import com.devlee.daggerhiltexample.domain.repository.MyRepository
import dagger.Lazy
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


// ViewModel에 생성자를 넣기 위해서는 ViewModelFactory 클래스를 만들어서 사용해야한다.
// Dagger-Hilt를 사용하면 Factory 클래스를 생성하지 않고 @Inject 어노테이션을 통해
// 의존성 주입이 가능하다.
@HiltViewModel
class MyViewModel @Inject constructor(
    private val repository: Lazy<MyRepository>
) : ViewModel(){

    init {
        repository.get()
    }

}