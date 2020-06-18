## Sekreto - Seed Code Generator

Sekreto, that means secret in [Esperanto](http://esperanto.net/en/), is a very simple project that aims to add a very tiny layer of convenience _(security?)_ over your cryptocurrency wallet.


#### How usually people store their seed words?

The seed words is a list of 12, 18 or 24 words, generated by the wallet software, using a predefined list of 2048 words, as described in the [Bitcoin Improvement Proposal 0039](https://github.com/bitcoin/bips/blob/master/bip-0039.mediawiki).

Example:
>sorry flower fall math uniform horror voyage enroll school cube any tomorrow

The user must write down these words in a paper sheet, because it **MUST NOT BE STORED ONLINE**, and hide this paper somewhere at home.
One common practice, is to have multiple copies of this paper and keep in multiple locations, in case your copy get damaged by water, fire, or if someone breaks into your home and you just eat it. =)

The major problem here, is that **anyone that have access to any of these copies, can completely steal all your Bitcoins**.

### How Sekreto can help?

Inspired by what [CoolWallet](https://www.coolwallet.io) did, instead of generating 24 words, they generate 24 numeric codes, and if you need to use it as words to recovery in any other wallet, they have a [conversion table](https://www.coolwallet.io/wp-content/uploads/2020/04/Number-seed-conversion-v1.pdf) that you can use to find what are the words correspondents to your numeric seed, but it's the same for everyone.

What Sekreto does is to generate an individual _"conversion table"_ that also maps a code to a word, and every generated table is unique.

Since the codes are randomly generated for every single table, you can keep a copy of it online and have multiple copies of your seed paper with the generated codes in a _(bit more)_ safest way.

### !!! Generating the code table !!!
Sekreto is running on heroku, all what you need to do is to use the generator link do create as many code tables as you want.

The link below goes direct to the generator API, just click on it to generate a code table!

[https://sekreto.herokuapp.com](https://sekreto.herokuapp.com/sekreto)


### How to generate the table offline
_(TODO) - A CLI application will be available soon._

### How to map your seed words
_(TODO)_

### How to check if I took notes of the right codes for my seed
_(TODO)_
