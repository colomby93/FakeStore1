package com.example.fakestore.ui.domain.model

sealed class FakeStoreError {
    data object Network : FakeStoreError()
    data object Default : FakeStoreError()
}

object Success