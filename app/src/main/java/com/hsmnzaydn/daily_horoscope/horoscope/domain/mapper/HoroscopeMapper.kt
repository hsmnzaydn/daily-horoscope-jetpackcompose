import com.hsmnzaydn.daily_horoscope.horoscope.data.entities.DescriptionResponse
import com.hsmnzaydn.daily_horoscope.horoscope.data.entities.HoroscopeResponse
import com.hsmnzaydn.daily_horoscope.horoscope.domain.entities.Description
import com.hsmnzaydn.daily_horoscope.horoscope.domain.entities.Horoscope

fun HoroscopeResponse.toHoroscope(): Horoscope = Horoscope(
    "https://"+imagePath,
    id,
    horoscopeName,
    descriptions = this.descriptionResponse?.map {
        it.toDescription()
    }?: emptyList()
)

fun DescriptionResponse.toDescription(): Description = Description(
    title,
    description
)