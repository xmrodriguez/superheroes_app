package com.superheroes.data.repository

import android.util.Log
import com.superheroes.domain.model.SuperHero
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SuperHeroRepository {
    companion object {
        private const val BIT_TIME = 1500L
        private const val TAG = "SuperHeroRepository"
    }

    private val superHeroes: List<SuperHero>

    init {
        superHeroes = fakeData();

        val apiInterface = ApiInterface.create().getSuperHeroes()

        //apiInterface.enqueue( Callback<List<Movie>>())
        apiInterface.enqueue( object : Callback<List<SuperHero>> {
            override fun onResponse(call: Call<List<SuperHero>>?, response: Response<List<SuperHero>>?) {
                System.out.println("Hola 1");
                if(response?.body() != null)
                    System.out.println(response?.body())
                    System.out.println("Hola 2");
                    //recyclerAdapter.setMovieListItems(response.body()!!)
            }

            override fun onFailure(call: Call<List<SuperHero>>?, t: Throwable?) {
                System.out.println("Hola 3");
            }
        })
    }

    fun getAllSuperHeroes(): List<SuperHero> {
        waitABit()
        return superHeroes
    }

    fun getByName(name: String): SuperHero {
        waitABit()
        return superHeroes.first { it.name == name }
    }

    private fun waitABit() {
        try {
            Thread.sleep(BIT_TIME)
        } catch (e: InterruptedException) {
            Log.d(TAG, "wait a bit failed.", e)
        }
    }

    private fun fakeData(): List<SuperHero> {
        return listOf(
            SuperHero(
                id = "1",
                name = "Una bomba",
                image = "https://www.superherodb.com/pictures2/portraits/10/100/10060.jpg",
                powerstats = """
                    Intelligence: 38
                    Strength: 100
                    Speed: 17
                    Durability: 80
                    Power: 24
                    Combat: 64
                """.trimIndent(),
                biography = """
                    Full name: Richard Milhouse Jones
                    Alter egos: No alter egos found.
                    Aliases: Rick Jones
                    Place of birth: Scarsdale, Arizona
                    First appearance: Hulk Vol 2 #2 (April, 2008) (as A-Bomb)
                    Publisher: Marvel Comics
                    Alignment: good
                """.trimIndent(),
                appearance = """
                    Gender: Male
                    Race: Human
                    Height: 203 cm
                    Weight: 441 kg
                    Eye color: Yellow
                    Hair color: No Hair
                """.trimIndent(),
                work = """
                    Occupation: Musician, adventurer, author; formerly talk show host
                    Base: -
                """.trimIndent(),
                connections = """
                    Group affiliation: Hulk Family; Excelsior (sponsor), Avengers (honorary member); formerly partner of the Hulk, Captain America and Captain Marvel; Teen Brigade; ally of Rom,
                    Relatives: Marlo Chandler-Jones (wife); Polly (aunt); Mrs. Chandler (mother-in-law); Keith Chandler, Ray Chandler, three unidentified others (brothers-in-law); unidentified father (deceased); Jackie Shorr (alleged mother; unconfirmed)
                """.trimIndent()
            ),
            SuperHero(
                id = "1",
                name = "Abe Sapien",
                image = "https://www.superherodb.com/pictures2/portraits/10/100/956.jpg",
                powerstats = """
                    Intelligence: 88
                    Strength: 28
                    Speed: 35
                    Durability: 65
                    Power: 100
                    Combat: 85
                """.trimIndent(),
                biography = """
                    Full name: Abraham Sapien
                    Alter egos: No alter egos found.
                    Aliases: Langdon Everett Caul, Abraham Sapien, Langdon Caul
                    Place of birth: -
                    First appearance: Hellboy: Seed of Destruction (1993)
                    Publisher: Dark Horse Comics
                    Alignment: good
                """.trimIndent(),
                appearance = """
                    Gender: Male
                    Race: Icthyo Sapien
                    Height: 191 cm
                    Weight: 65 kg
                    Eye color: Blue
                    Hair color: No Hair
                """.trimIndent(),
                work = """
                    Occupation: Paranormal Investigator
                    Base: -
                """.trimIndent(),
                connections = """
                    Group affiliation: Bureau for Paranormal Research and Defense
                    Relatives: Edith Howard (wife, deceased)
                """.trimIndent()
            ),
            SuperHero(
                id = "1",
                name = "Abin Sur",
                image = "https://www.superherodb.com/pictures2/portraits/10/100/1460.jpg",
                powerstats = """
                    Intelligence: 50
                    Strength: 90
                    Speed: 53
                    Durability: 64
                    Power: 99
                    Combat: 65
                """.trimIndent(),
                biography = """
                    Full name: 
                    Alter egos: No alter egos found.
                    Aliases: Lagzia
                    Place of birth: Ungara
                    First appearance: Showcase #22 (October, 1959)
                    Publisher: DC Comics
                    Alignment: good
                """.trimIndent(),
                appearance = """
                    Gender: Male
                    Race: Ungaran
                    Height: 185 cm
                    Weight: 90 kg
                    Eye color: Blue
                    Hair color: No Hair
                """.trimIndent(),
                work = """
                    Occupation: Green Lantern, former history professor
                    Base: Oa
                """.trimIndent(),
                connections = """
                    Group affiliation: Green Lantern Corps, Black Lantern Corps
                    Relatives: Amon Sur (son), Arin Sur (sister), Thaal Sinestro (brother-in-law), Soranik Natu (niece)
                """.trimIndent()
            ),
            SuperHero(
                id = "1",
                name = "Abomination",
                image = "https://www.superherodb.com/pictures2/portraits/10/100/1.jpg",
                powerstats = """
                    Intelligence: 63
                    Strength: 80
                    Speed: 53
                    Durability: 90
                    Power: 62
                    Combat: 95
                """.trimIndent(),
                biography = """
                    Full name: Emil Blonsky
                    Alter egos: No alter egos found.
                    Aliases: Agent R-7, Ravager of Worlds
                    Place of birth: Zagreb, Yugoslavia
                    First appearance: Tales to Astonish #90
                    Publisher: Marvel Comics
                    Alignment: bad
                """.trimIndent(),
                appearance = """
                    Gender: Male
                    Race: Human / Radiation
                    Height: 203 cm
                    Weight: 441 kg
                    Eye color: Green
                    Hair color: No Hair
                """.trimIndent(),
                work = """
                    Occupation: Ex-Spy
                    Base: Mobile
                """.trimIndent(),
                connections = """
                    Group affiliation: former member of the crew of the Andromeda Starship, ally of the Abominations and Forgotten
                    Relatives: Nadia Dornova Blonsky (wife, separated)
                """.trimIndent()
            ),
            SuperHero(
                id = "1",
                name = "Abraxas",
                image = "https://www.superherodb.com/pictures2/portraits/10/100/181.jpg",
                powerstats = """
                    Intelligence: 88
                    Strength: 63
                    Speed: 83
                    Durability: 100
                    Power: 100
                    Combat: 55
                """.trimIndent(),
                biography = """
                    Full name: Abraxas
                    Alter egos: No alter egos found.
                    Aliases: -
                    Place of birth: Within Eternity
                    First appearance: Fantastic Four Annual #2001
                    Publisher: Marvel Comics
                    Alignment: bad
                """.trimIndent(),
                appearance = """
                    Gender: Male
                    Race: Cosmic Entity
                    Height: 0 cm
                    Weight: 0 kg
                    Eye color: Blue
                    Hair color: Black
                """.trimIndent(),
                work = """
                    Occupation: Dimensional destroyer
                    Base: -
                """.trimIndent(),
                connections = """
                    Group affiliation: Cosmic Beings
                    Relatives: Eternity (\"Father\")
                """.trimIndent()
            )
        )
    }
}