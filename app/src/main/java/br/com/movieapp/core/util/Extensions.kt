package br.com.movieapp.core.util

import br.com.movieapp.BuildConfig

fun String?.toPostUrl() = "${BuildConfig.BASE_IMAGE_URL}$this"

fun String?.toBackdropUrl() = "${BuildConfig.BASE_IMAGE_URL}$this"