package com.example.searchwindowgit.utilities

import kotlinx.serialization.json.Json

val jsonDefaultInstance = Json { ignoreUnknownKeys = true; isLenient = true; encodeDefaults = false }