package com.example.a3w1_0706012110012.Model

import android.os.Parcel
import android.os.Parcelable

data class Hewan(
    var namaH: String?,
    var jenisH: String?,
    var usiaH: String?,

    ):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }
    var imageUri:String?=""

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(namaH)
        parcel.writeString(jenisH)
        parcel.writeString(usiaH)
    }


    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Hewan> {
        override fun createFromParcel(parcel: Parcel): Hewan {
            return Hewan(parcel)
        }

        override fun newArray(size: Int): Array<Hewan?> {
            return arrayOfNulls(size)
        }
    }
}