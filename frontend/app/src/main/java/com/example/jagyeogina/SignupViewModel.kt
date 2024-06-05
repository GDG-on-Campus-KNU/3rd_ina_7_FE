package com.example.jagyeogina

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignupViewModel : ViewModel() {
    private val _id = MutableLiveData<String>()
    val id: LiveData<String> get() = _id

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> get() = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> get() = _password

    private val _nickname = MutableLiveData<String>()
    val nickname: LiveData<String> get() = _nickname

    private val _birthdate = MutableLiveData<String>()
    val birthdate: LiveData<String> get() = _birthdate

    private val _idValidation = MutableLiveData<String>()
    val idValidation: LiveData<String> get() = _idValidation

    private val _pwValidation = MutableLiveData<String>()
    val pwValidation: LiveData<String> get() = _pwValidation


    private val _emailValidation = MutableLiveData<String>()
    val emailValidation: LiveData<String> get() = _emailValidation

    private val _nicknameValidation = MutableLiveData<String>()
    val nicknameValidation: LiveData<String> get() = _nicknameValidation

    fun setId(id: String) {
        _id.value = id
    }

    fun setEmail(email: String) {
        _email.value = email
    }

    fun setPassword(password: String) {
        _password.value = password
    }

    fun setNickname(nickname: String) {
        _nickname.value = nickname
    }

    fun setBirthdate(birthdate: String) {
        _birthdate.value = birthdate
    }

    fun setIdValidation(idValidation: String) {
        _idValidation.value = idValidation
    }

    fun setPwValidation(pwValidation: String) {
        _pwValidation.value = pwValidation
    }

    fun setEmailValidation(emailValidation: String) {
        _emailValidation.value = emailValidation
    }

    fun setNicknameValidation(nicknameValidation: String) {
        _nicknameValidation.value = nicknameValidation
    }
}