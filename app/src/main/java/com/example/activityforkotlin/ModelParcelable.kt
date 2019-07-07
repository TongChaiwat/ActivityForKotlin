package com.example.activityforkotlin

import android.os.Parcel
import android.os.Parcelable

class ModelParcelable() : Parcelable {

    var name: String? = null
    var age: Int? = null
    var isMarred: Boolean = false

    constructor(parcel: Parcel) : this() {
        name = parcel.readString()
        age = parcel.readValue(Int::class.java.classLoader) as? Int
        isMarred = parcel.readByte() != 0.toByte()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeValue(age)
        parcel.writeByte(if (isMarred) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ModelParcelable> {
        override fun createFromParcel(parcel: Parcel): ModelParcelable {
            return ModelParcelable(parcel)
        }

        override fun newArray(size: Int): Array<ModelParcelable?> {
            return arrayOfNulls(size)
        }
    }


}