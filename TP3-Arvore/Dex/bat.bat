@echo off
chcp 65001
echo on

setlocal enabledelayedexpansion

rem Vetores
set files[0]=bulbasaur.txt
set files[1]=ivysaur.txt
set files[2]=venusaur.txt
set files[3]=charmander.txt
set files[4]=charmeleon.txt
set files[5]=charizard.txt
set files[6]=squirtle.txt
set files[7]=wartortle.txt
set files[8]=blastoise.txt
set files[9]=caterpie.txt
set files[10]=metapod.txt
set files[11]=butterfree.txt
set files[12]=weedle.txt
set files[13]=kakuna.txt
set files[14]=beedrill.txt
set files[15]=pidgey.txt
set files[16]=pidgeotto.txt
set files[17]=pidgeot.txt
set files[18]=rattata.txt
set files[19]=raticate.txt
set files[20]=spearow.txt
set files[21]=fearow.txt
set files[22]=ekans.txt
set files[23]=arbok.txt
set files[24]=pikachu.txt
set files[25]=raichu.txt
set files[26]=sandshrew.txt
set files[27]=sandslash.txt
set files[28]=nidoranf.txt
set files[29]=nidorina.txt
set files[30]=nidoqueen.txt
set files[31]=nidoranm.txt
set files[32]=nidorino.txt
set files[33]=nidoking.txt
set files[34]=clefairy.txt
set files[35]=clefable.txt
set files[36]=vulpix.txt
set files[37]=ninetales.txt
set files[38]=jigglypuff.txt
set files[39]=wigglytuff.txt
set files[40]=zubat.txt
set files[41]=golbat.txt
set files[42]=oddish.txt
set files[43]=gloom.txt
set files[44]=vileplume.txt
set files[45]=paras.txt
set files[46]=parasect.txt
set files[47]=venonat.txt
set files[48]=venomoth.txt
set files[49]=diglett.txt
set files[50]=dugtrio.txt
set files[51]=meowth.txt
set files[52]=persian.txt
set files[53]=psyduck.txt
set files[54]=golduck.txt
set files[55]=mankey.txt
set files[56]=primeape.txt
set files[57]=growlithe.txt
set files[58]=arcanine.txt
set files[59]=poliwag.txt
set files[60]=poliwhirl.txt
set files[61]=poliwrath.txt
set files[62]=abra.txt
set files[63]=kadabra.txt
set files[64]=alakazam.txt
set files[65]=machop.txt
set files[66]=machoke.txt
set files[67]=machamp.txt
set files[68]=bellsprout.txt
set files[69]=weepinbell.txt
set files[70]=victreebel.txt
set files[71]=tentacool.txt
set files[72]=tentacruel.txt
set files[73]=geodude.txt
set files[74]=graveler.txt
set files[75]=golem.txt
set files[76]=ponyta.txt
set files[77]=rapidash.txt
set files[78]=slowpoke.txt
set files[79]=slowbro.txt
set files[80]=magnemite.txt
set files[81]=magneton.txt
set files[82]=farfetchd.txt
set files[83]=doduo.txt
set files[84]=dodrio.txt
set files[85]=seel.txt
set files[86]=dewgong.txt
set files[87]=grimer.txt
set files[88]=muk.txt
set files[89]=shellder.txt
set files[90]=cloyster.txt
set files[91]=gastly.txt
set files[92]=haunter.txt
set files[93]=gengar.txt
set files[94]=onix.txt
set files[95]=drowzee.txt
set files[96]=hypno.txt
set files[97]=krabby.txt
set files[98]=kingler.txt
set files[99]=voltorb.txt
set files[100]=electrode.txt
set files[101]=exeggcute.txt
set files[102]=exeggutor.txt
set files[103]=cubone.txt
set files[104]=marowak.txt
set files[105]=hitmonlee.txt
set files[106]=hitmonchan.txt
set files[107]=lickitung.txt
set files[108]=koffing.txt
set files[109]=weezing.txt
set files[110]=rhyhorn.txt
set files[111]=rhydon.txt
set files[112]=chansey.txt
set files[113]=tangela.txt
set files[114]=kangaskhan.txt
set files[115]=horsea.txt
set files[116]=seadra.txt
set files[117]=goldeen.txt
set files[118]=seaking.txt
set files[119]=staryu.txt
set files[120]=starmie.txt
set files[121]=mrmime.txt
set files[122]=scyther.txt
set files[123]=jynx.txt
set files[124]=electabuzz.txt
set files[125]=magmar.txt
set files[126]=pinsir.txt
set files[127]=tauros.txt
set files[128]=magikarp.txt
set files[129]=gyarados.txt
set files[130]=lapras.txt
set files[131]=ditto.txt
set files[132]=eevee.txt
set files[133]=vaporeon.txt
set files[134]=jolteon.txt
set files[135]=flareon.txt
set files[136]=porygon.txt
set files[137]=omanyte.txt
set files[138]=omastar.txt
set files[139]=kabuto.txt
set files[140]=kabutops.txt
set files[141]=aerodactyl.txt
set files[142]=snorlax.txt
set files[143]=articuno.txt
set files[144]=zapdos.txt
set files[145]=moltres.txt
set files[146]=dratini.txt
set files[147]=dragonair.txt
set files[148]=dragonite.txt
set files[149]=mewtwo.txt
set files[150]=mew.txt

setlocal enabledelayedexpansion

set values[0]=Bulbasaur
Tipo: Planta/Veneno
Número: 001
Pré: Nenhuma
Pós: Ivysaur

Descrição:
Bulbasaur, o Pokémon Semente, é um dos três iniciais da região de Kanto. Ele possui uma planta nas costas que cresce conforme ele evolui. Bulbasaur é amigável e leal, mas também bastante protetor quando se trata de seus amigos e seu território.

set values[1]=Ivysaur
Tipo: Planta/Veneno
Número: 002
Pré: Bulbasaur
Pós: Venusaur

Descrição:
Ivysaur, o Pokémon Semente, é a evolução de Bulbasaur. A planta nas suas costas começou a florescer e emite um aroma doce quando está prestes a evoluir para Venusaur.

set values[2]=Venusaur
Tipo: Planta/Veneno
Número: 003
Pré: Ivysaur
Pós: Nenhuma

Descrição:
Venusaur, o Pokémon Semente, é conhecido por sua poderosa flor nas costas. Essa flor absorve luz solar para aumentar sua energia, tornando-o um Pokémon extremamente resistente.

set values[3]=Charmander
Tipo: Fogo
Número: 004
Pré: Nenhuma
Pós: Charmeleon

Descrição:
Charmander, o Pokémon Lagarto, é um dos iniciais da região de Kanto. A chama na ponta de sua cauda indica sua vitalidade e é extremamente importante para ele.

set values[4]=Charmeleon
Tipo: Fogo
Número: 005
Pré: Charmander
Pós: Charizard

Descrição:
Charmeleon, o Pokémon Chama, é uma evolução de Charmander. Ele é mais agressivo e sua cauda brilha intensamente quando está lutando.

set values[5]=Charizard
Tipo: Fogo/Voador
Número: 006
Pré: Charmeleon
Pós: Nenhuma

Descrição:
Charizard, o Pokémon Chama, é conhecido por seu poder de voo e por cuspir chamas tão quentes que podem derreter pedras.

set values[6]=Squirtle
Tipo: Água
Número: 007
Pré: Nenhuma
Pós: Wartortle

Descrição:
Squirtle, o Pokémon Tartaruga, é um inicial de Kanto. Ele usa seu casco como proteção e pode atirar jatos de água para se defender.

set values[7]=Wartortle
Tipo: Água
Número: 008
Pré: Squirtle
Pós: Blastoise

Descrição:
Wartortle, o Pokémon Tartaruga, é a evolução de Squirtle. Ele é mais experiente em batalha e usa sua cauda peluda como um símbolo de longevidade.

set values[8]=Blastoise
Tipo: Água
Número: 009
Pré: Wartortle
Pós: Nenhuma

Descrição:
Blastoise, o Pokémon Tartaruga, é famoso por seus canhões de água. Ele pode disparar jatos com pressão suficiente para perfurar aço.

set values[9]=Caterpie
Tipo: Inseto
Número: 010
Pré: Nenhuma
Pós: Metapod

Descrição:
Caterpie, o Pokémon Lagarta, é pequeno e inofensivo, mas pode usar um forte odor para afastar predadores. Ele evolui rapidamente para Metapod.

set values[10]=Metapod
Tipo: Inseto
Número: 011
Pré: Caterpie
Pós: Butterfree

Descrição:
Metapod, o Pokémon Casulo, é conhecido por sua casca dura. Ele permanece imóvel enquanto prepara sua evolução para Butterfree.

set values[11]=Butterfree
Tipo: Inseto/Voador
Número: 012
Pré: Metapod
Pós: Nenhuma

Descrição:
Butterfree, o Pokémon Borboleta, é uma criatura graciosa que usa pólen de suas asas para lutar. Ele é capaz de encontrar flores a grandes distâncias.

set values[12]=Weedle
Tipo: Inseto/Veneno
Número: 013
Pré: Nenhuma
Pós: Kakuna

Descrição:
Weedle, o Pokémon Larva, é conhecido por seu ferrão venenoso e sua habilidade de enrolar folhas para se esconder de predadores.

set values[13]=Kakuna
Tipo: Inseto/Veneno
Número: 014
Pré: Weedle
Pós: Beedrill

Descrição:
Kakuna, o Pokémon Casulo, é imóvel e parece vulnerável, mas está se preparando para se tornar o agressivo Beedrill.

set values[14]=Beedrill
Tipo: Inseto/Veneno
Número: 015
Pré: Kakuna
Pós: Nenhuma

Descrição:
Beedrill, o Pokémon Abelha, é rápido e perigoso. Seus ferrões são usados para ataques precisos e podem ser extremamente venenosos.

set values[15]=Pidgey
Tipo: Normal/Voador
Número: 016
Pré: Nenhuma
Pós: Pidgeotto

Descrição:
Pidgey, o Pokémon Pássaro Pequeno, é dócil e prefere evitar confrontos. Ele é capaz de criar pequenas rajadas de vento com o bater de suas asas.

set values[16]=Pidgeotto
Tipo: Normal/Voador
Número: 017
Pré: Pidgey
Pós: Pidgeot

Descrição:
Pidgeotto, o Pokémon Pássaro, é territorial e protege seu habitat com vigor. Ele usa suas garras afiadas para atacar.

set values[17]=Pidgeot
Tipo: Normal/Voador
Número: 018
Pré: Pidgeotto
Pós: Nenhuma

Descrição:
Pidgeot, o Pokémon Pássaro, é majestoso e extremamente rápido. Suas asas poderosas podem criar rajadas de vento devastadoras.

set values[18]=Rattata
Tipo: Normal
Número: 019
Pré: Nenhuma
Pós: Raticate

Descrição:
Rattata, o Pokémon Rato, é pequeno, mas persistente. Ele é conhecido por roer qualquer coisa para manter seus dentes afiados.

set values[19]=Raticate
Tipo: Normal
Número: 020
Pré: Rattata
Pós: Nenhuma

Descrição:
Raticate, o Pokémon Rato, é feroz e possui dentes extremamente fortes. Ele pode nadar em rios e escalar edifícios para encontrar comida.

set values[20]=Spearow
Tipo: Normal/Voador
Número: 021
Pré: Nenhuma
Pós: Fearow

Descrição:
Spearow, o Pokémon Pássaro Pequeno, é muito territorial e agressivo. Ele usa seu grito estridente para alertar outros Spearow.

set values[21]=Fearow
Tipo: Normal/Voador
Número: 022
Pré: Spearow
Pós: Nenhuma

Descrição:
Fearow, o Pokémon Bico, é conhecido por sua habilidade de voar grandes distâncias. Seu longo pescoço e bico afiado o tornam um caçador eficiente.

set values[22]=Ekans
Tipo: Veneno
Número: 023
Pré: Nenhuma
Pós: Arbok

Descrição:
Ekans, o Pokémon Cobra, pode enrolar-se para descansar ou atacar. Ele é ágil e usa suas presas venenosas para capturar presas.

set values[23]=Arbok
Tipo: Veneno
Número: 024
Pré: Ekans
Pós: Nenhuma

Descrição:
Arbok, o Pokémon Cobra, é assustador e mortal. Os padrões em seu corpo podem hipnotizar ou intimidar inimigos.

set values[24]=Pikachu
Tipo: Elétrico
Número: 025
Pré: Nenhuma
Pós: Raichu

Descrição:
Pikachu, o Pokémon Rato Elétrico, é adorado por sua aparência fofa e suas bochechas elétricas. Ele armazena energia para liberar ataques poderosos.

set values[25]=Raichu
Tipo: Elétrico
Número: 026
Pré: Pikachu
Pós: Nenhuma

Descrição:
Raichu, o Pokémon Rato Elétrico, é mais forte que Pikachu. Ele descarrega eletricidade através de sua cauda e pode causar apagões.

set values[26]=Sandshrew
Tipo: Terra
Número: 027
Pré: Nenhuma
Pós: Sandslash

Descrição:
Sandshrew, o Pokémon Rato, é conhecido por sua habilidade de enrolar-se para se proteger. Ele vive em áreas secas e cavar buracos é sua especialidade.

set values[27]=Sandslash
Tipo: Terra
Número: 028
Pré: Sandshrew
Pós: Nenhuma

Descrição:
Sandslash, o Pokémon Rato, possui garras afiadas que usa para escavar e se defender. Ele pode enrolar-se como Sandshrew, mas é muito mais resistente.

set values[28]=Nidoran♀
Tipo: Veneno
Número: 029
Pré: Nenhuma
Pós: Nidorina

Descrição:
Nidoran♀, o Pokémon Agulha Venenosa, é pequeno, mas possui um veneno poderoso. Suas orelhas são altamente sensíveis a sons.

set values[29]=Nidorina
Tipo: Veneno
Número: 030
Pré: Nidoran♀
Pós: Nidoqueen

Descrição:
Nidorina, o Pokémon Agulha Venenosa, é cuidadosa e protetora com seus companheiros. Seu corpo é mais resistente que o de Nidoran♀.

set values[30]=Nidoqueen
Tipo: Veneno/Terra
Número: 031
Pré: Nidorina
Pós: Nenhuma

Descrição:
Nidoqueen, o Pokémon Broca, é extremamente protetora e usa seu corpo resistente para proteger seus aliados e seu território.

set values[31]=Nidoran♂
Tipo: Veneno
Número: 032
Pré: Nenhuma
Pós: Nidorino

Descrição:
Nidoran♂, o Pokémon Agulha Venenosa, possui espinhos venenosos e é mais agressivo que sua contraparte fêmea. Ele ataca ferozmente quando ameaçado.

set values[32]=Nidorino
Tipo: Veneno
Número: 033
Pré: Nidoran♂
Pós: Nidoking

Descrição:
Nidorino, o Pokémon Agulha Venenosa, é altamente agressivo. Seus espinhos emitem veneno quando ele está irritado ou em combate.

set values[33]=Nidoking
Tipo: Veneno/Terra
Número: 034
Pré: Nidorino
Pós: Nenhuma

Descrição:
Nidoking, o Pokémon Broca, usa sua força imensa e cauda poderosa para destruir obstáculos e derrotar inimigos com facilidade.

set values[34]=Clefairy
Tipo: Fada
Número: 035
Pré: Nenhuma
Pós: Clefable

Descrição:
Clefairy, o Pokémon Fada, é adorado por sua aparência encantadora. Ele dança à luz da lua e acredita-se que traz sorte para quem o encontra.

set values[35]=Clefable
Tipo: Fada
Número: 036
Pré: Clefairy
Pós: Nenhuma

Descrição:
Clefable, o Pokémon Fada, é conhecido por sua natureza calma. Ele tem uma audição incrivelmente sensível e prefere viver em lugares tranquilos.

set values[36]=Vulpix
Tipo: Fogo
Número: 037
Pré: Nenhuma
Pós: Ninetales

Descrição:
Vulpix, o Pokémon Raposa, nasce com uma única cauda que se divide conforme cresce. Ele pode expelir chamas para se defender.

set values[37]=Ninetales
Tipo: Fogo
Número: 038
Pré: Vulpix
Pós: Nenhuma

Descrição:
Ninetales, o Pokémon Raposa, é majestoso e cheio de mistérios. Cada uma de suas nove caudas possui poderes místicos.

set values[38]=Jigglypuff
Tipo: Normal/Fada
Número: 039
Pré: Nenhuma
Pós: Wigglytuff

Descrição:
Jigglypuff, o Pokémon Balão, é conhecido por sua voz hipnótica. Ele canta para fazer seus inimigos dormirem durante batalhas.

set values[39]=Wigglytuff
Tipo: Normal/Fada
Número: 040
Pré: Jigglypuff
Pós: Nenhuma

Descrição:
Wigglytuff, o Pokémon Balão, possui uma pele extremamente macia. Ele infla seu corpo para intimidar adversários.

set values[40]=Zubat
Tipo: Veneno/Voador
Número: 041
Pré: Nenhuma
Pós: Golbat

Descrição:
Zubat, o Pokémon Morcego, é cego, mas usa ondas ultrassônicas para se orientar. Ele vive em cavernas escuras com grandes colônias.

set values[41]=Golbat
Tipo: Veneno/Voador
Número: 042
Pré: Zubat
Pós: Nenhuma

Descrição:
Golbat, o Pokémon Morcego, é noturno e suga o sangue de suas presas para se alimentar. Ele voa rapidamente, mesmo em lugares apertados.

set values[42]=Oddish
Tipo: Planta/Veneno
Número: 043
Pré: Nenhuma
Pós: Gloom

Descrição:
Oddish, o Pokémon Erva, cresce melhor à noite e enterra suas raízes no solo para absorver nutrientes enquanto dorme.

set values[43]=Gloom
Tipo: Planta/Veneno
Número: 044
Pré: Oddish
Pós: Vileplume

Descrição:
Gloom, o Pokémon Erva, emite um cheiro pungente de sua flor. Apesar de desagradável, é um sinal de que está saudável.

set values[44]=Vileplume
Tipo: Planta/Veneno
Número: 045
Pré: Gloom
Pós: Nenhuma

Descrição:
Vileplume, o Pokémon Flor, possui uma das maiores flores entre os Pokémon. Ele espalha esporos venenosos para se proteger e atacar.

set values[45]=Paras
Tipo: Inseto/Planta
Número: 046
Pré: Nenhuma
Pós: Parasect

Descrição:
Paras, o Pokémon Cogumelo, tem cogumelos que crescem em suas costas. Ele vive em florestas escuras e prefere locais úmidos.

set values[46]=Parasect
Tipo: Inseto/Planta
Número: 047
Pré: Paras
Pós: Nenhuma

Descrição:
Parasect, o Pokémon Cogumelo, é controlado pelo cogumelo parasítico em suas costas. Ele espalha esporos para sobreviver.

set values[47]=Venonat
Tipo: Inseto/Veneno
Número: 048
Pré: Nenhuma
Pós: Venomoth

Descrição:
Venonat, o Pokémon Inseto, possui olhos grandes e sensíveis que detectam movimentos no escuro. Ele cobre o corpo com uma fina camada de veneno.

set values[48]=Venomoth
Tipo: Inseto/Veneno
Número: 049
Pré: Venonat
Pós: Nenhuma

Descrição:
Venomoth, o Pokémon Mariposa Venenosa, espalha pó venenoso de suas asas durante o voo. Ele prefere caçar à noite.

set values[49]=Diglett
Tipo: Terra
Número: 050
Pré: Nenhuma
Pós: Dugtrio

Descrição:
Diglett, o Pokémon Toupeira, vive debaixo da terra e raramente é visto. Ele ajuda a arar campos cavando túneis.

set values[50]=Dugtrio
Tipo: Terra
Número: 051
Pré: Diglett
Pós: Nenhuma

Descrição:
Dugtrio, o Pokémon Toupeira, é formado por três Diglett que cooperam para cavar mais rapidamente. Ele é incrivelmente rápido.

set values[51]=Meowth
Tipo: Normal
Número: 052
Pré: Nenhuma
Pós: Persian

Descrição:
Meowth, o Pokémon Gato Arranhador, é ágil e adora objetos brilhantes. Ele é conhecido por sua habilidade de produzir moedas usando seu ataque Payday.

set values[52]=Persian
Tipo: Normal
Número: 053
Pré: Meowth
Pós: Nenhuma

Descrição:
Persian, o Pokémon Gato Elegante, é orgulhoso e gracioso. Ele se move com elegância e pode atacar com garras afiadas.

set values[53]=Psyduck
Tipo: Água
Número: 054
Pré: Nenhuma
Pós: Golduck

Descrição:
Psyduck, o Pokémon Pato, sofre frequentemente de dores de cabeça. Quando a dor atinge seu pico, ele libera misteriosos poderes psíquicos.

set values[54]=Golduck
Tipo: Água
Número: 055
Pré: Psyduck
Pós: Nenhuma

Descrição:
Golduck, o Pokémon Pato, é um nadador veloz e ágil. Ele é frequentemente visto em rios e lagos, exibindo habilidades aquáticas incríveis.

set values[55]=Mankey
Tipo: Lutador
Número: 056
Pré: Nenhuma
Pós: Primeape

Descrição:
Mankey, o Pokémon Macaco, é conhecido por sua natureza extremamente temperamental. Ele pode se enfurecer com facilidade e atacar em grupos.

set values[56]=Primeape
Tipo: Lutador
Número: 057
Pré: Mankey
Pós: Nenhuma

Descrição:
Primeape, o Pokémon Macaco, é sempre furioso e difícil de controlar. Sua força aumenta quanto mais irritado ele fica.

set values[57]=Growlithe
Tipo: Fogo
Número: 058
Pré: Nenhuma
Pós: Arcanine

Descrição:
Growlithe, o Pokémon Cachorro, é leal e corajoso. Ele protege seu território ferozmente e obedece seu treinador sem questionar.

set values[58]=Arcanine
Tipo: Fogo
Número: 059
Pré: Growlithe
Pós: Nenhuma

Descrição:
Arcanine, o Pokémon Lendário, é majestoso e incrivelmente rápido. Ele é conhecido por sua coragem e lealdade incomparáveis.

set values[59]=Poliwag
Tipo: Água
Número: 060
Pré: Nenhuma
Pós: Poliwhirl

Descrição:
Poliwag, o Pokémon Girino, possui uma pele fina que revela seus órgãos internos. Ele nada agilmente em água doce e limpa.

set values[60]=Poliwhirl
Tipo: Água
Número: 061
Pré: Poliwag
Pós: Poliwrath

Descrição:
Poliwhirl, o Pokémon Girino, tem um corpo úmido e escorregadio. Ele pode usar suas patas poderosas para atacar e nadar contra correntes fortes.

set values[61]=Poliwrath
Tipo: Água/Lutador
Número: 062
Pré: Poliwhirl
Pós: Nenhuma

Descrição:
Poliwrath, o Pokémon Girino, é extremamente forte e resistente. Ele nada vastas distâncias com facilidade, utilizando seus músculos robustos.

set values[62]=Abra
Tipo: Psíquico
Número: 063
Pré: Nenhuma
Pós: Kadabra

Descrição:
Abra, o Pokémon Psíquico, passa a maior parte do tempo dormindo para manter suas habilidades psíquicas. Ele é capaz de se teletransportar em caso de perigo.

set values[63]=Kadabra
Tipo: Psíquico
Número: 064
Pré: Abra
Pós: Alakazam

Descrição:
Kadabra, o Pokémon Psíquico, emite uma onda psíquica constante que pode causar dores de cabeça. Ele é conhecido por carregar uma colher para amplificar seus poderes.

set values[64]=Alakazam
Tipo: Psíquico
Número: 065
Pré: Kadabra
Pós: Nenhuma

Descrição:
Alakazam, o Pokémon Psíquico, possui uma inteligência extraordinária. Diz-se que seu cérebro nunca para de crescer, aumentando continuamente sua sabedoria.

set values[65]=Machop
Tipo: Lutador
Número: 066
Pré: Nenhuma
Pós: Machoke

Descrição:
Machop, o Pokémon Superpoderoso, treina constantemente para melhorar sua força. Ele consegue levantar e carregar objetos várias vezes maiores que seu peso.

set values[66]=Machoke
Tipo: Lutador
Número: 067
Pré: Machop
Pós: Machamp

Descrição:
Machoke, o Pokémon Superpoderoso, é muito musculoso e pode realizar feitos impressionantes de força. Ele usa um cinto para conter seu poder.

set values[67]=Machamp
Tipo: Lutador
Número: 068
Pré: Machoke
Pós: Nenhuma

Descrição:
Machamp, o Pokémon Superpoderoso, possui quatro braços que lhe permitem realizar ataques rápidos e precisos. Ele é mestre em combate corpo a corpo.

set values[68]=Bellsprout
Tipo: Planta/Veneno
Número: 069
Pré: Nenhuma
Pós: Weepinbell

Descrição:
Bellsprout, o Pokémon Flor, é ágil e pode girar seu corpo para desviar de ataques. Ele absorve nutrientes usando suas raízes.

set values[69]=Weepinbell
Tipo: Planta/Veneno
Número: 070
Pré: Bellsprout
Pós: Victreebel

Descrição:
Weepinbell, o Pokémon Carnívoro, secreta um ácido para dissolver presas pequenas. Ele prefere viver em árvores para caçar de forma eficiente.

set values[70]=Victreebel
Tipo: Planta/Veneno
Número: 071
Pré: Weepinbell
Pós: Nenhuma

Descrição:
Victreebel, o Pokémon Carnívoro, atrai presas com seu aroma doce antes de engoli-las. Ele é encontrado em florestas densas e úmidas.

set values[71]=Tentacool
Tipo: Água/Veneno
Número: 072
Pré: Nenhuma
Pós: Tentacruel

Descrição:
Tentacool, o Pokémon Água-viva, possui um corpo translúcido que flutua no oceano. Ele utiliza seus tentáculos para se defender e capturar presas.

set values[72]=Tentacruel
Tipo: Água/Veneno
Número: 073
Pré: Tentacool
Pós: Nenhuma

Descrição:
Tentacruel, o Pokémon Água-viva, é agressivo e tem numerosos tentáculos venenosos. Ele pode criar ondas poderosas para afundar barcos.

set values[73]=Geodude
Tipo: Rocha/Terra
Número: 074
Pré: Nenhuma
Pós: Graveler

Descrição:
Geodude, o Pokémon Rocha, é frequentemente confundido com uma pedra. Ele vive em montanhas e é incrivelmente resistente.

set values[74]=Graveler
Tipo: Rocha/Terra
Número: 075
Pré: Geodude
Pós: Golem

Descrição:
Graveler, o Pokémon Rocha, adora descer morros rolando. Ele usa seu peso para esmagar obstáculos em seu caminho.

set values[75]=Golem
Tipo: Rocha/Terra
Número: 076
Pré: Graveler
Pós: Nenhuma

Descrição:
Golem, o Pokémon Rocha, é extremamente resistente. Ele se protege com uma carapaça dura e pode rolar morros com grande velocidade.

set values[76]=Ponyta
Tipo: Fogo
Número: 077
Pré: Nenhuma
Pós: Rapidash

Descrição:
Ponyta, o Pokémon Cavalo de Fogo, é ágil e rápido. Ele possui uma juba flamejante que cresce à medida que se torna mais forte.

set values[77]=Rapidash
Tipo: Fogo
Número: 078
Pré: Ponyta
Pós: Nenhuma

Descrição:
Rapidash, o Pokémon Cavalo de Fogo, é extremamente veloz e elegante. Ele é conhecido por sua corrida graciosa e suas chamas vibrantes.

set values[78]=Slowpoke
Tipo: Água/Psíquico
Número: 079
Pré: Nenhuma
Pós: Slowbro

Descrição:
Slowpoke, o Pokémon Preguiçoso, é lento e muitas vezes desatento. Ele gosta de pescar com sua cauda enquanto relaxa na água.

set values[79]=Slowbro
Tipo: Água/Psíquico
Número: 080
Pré: Slowpoke
Pós: Nenhuma

Descrição:
Slowbro, o Pokémon Simbiose, se tornou mais ágil após um Shellder morder sua cauda. Ele continua a ser calmo e relaxado.

set values[80]=Magnemite
Tipo: Elétrico/Aço
Número: 081
Pré: Nenhuma
Pós: Magneton

Descrição:
Magnemite, o Pokémon Magnético, flutua utilizando magnetismo. Ele emite ondas elétricas para paralisar inimigos e absorver energia.

set values[81]=Magneton
Tipo: Elétrico/Aço
Número: 082
Pré: Magnemite
Pós: Nenhuma

Descrição:
Magneton, o Pokémon Magnético, é formado por três Magnemite que se unem. Ele emite um campo magnético poderoso que interfere em dispositivos eletrônicos.

set values[82]=Farfetch'd
Tipo: Normal/Voador
Número: 083
Pré: Nenhuma
Pós: Nenhuma

Descrição:
Farfetch'd, o Pokémon Selvagem, carrega um talo de planta que usa como arma. Ele é astuto e valoriza muito seu talo.

set values[83]=Doduo
Tipo: Normal/Voador
Número: 084
Pré: Nenhuma
Pós: Dodrio

Descrição:
Doduo, o Pokémon Duplo, possui duas cabeças que trabalham juntas para vigiar o ambiente. Ele corre rapidamente em terrenos abertos.

set values[84]=Dodrio
Tipo: Normal/Voador
Número: 085
Pré: Doduo
Pós: Nenhuma

Descrição:
Dodrio, o Pokémon Tríplice, tem três cabeças que compartilham pensamentos. Ele é um corredor veloz e extremamente atento ao perigo.

set values[85]=Seel
Tipo: Água
Número: 086
Pré: Nenhuma
Pós: Dewgong

Descrição:
Seel, o Pokémon Marinho, vive em águas geladas e utiliza sua cauda para nadar com agilidade. Ele adora brincar em banquisas de gelo.

set values[86]=Dewgong
Tipo: Água/Gelo
Número: 087
Pré: Seel
Pós: Nenhuma

Descrição:
Dewgong, o Pokémon Marinho, é gracioso e ágil na água. Sua pele espessa o protege contra o frio intenso.

set values[87]=Grimer
Tipo: Veneno
Número: 088
Pré: Nenhuma
Pós: Muk

Descrição:
Grimer, o Pokémon Lodo, é formado por resíduos tóxicos. Ele contamina tudo ao seu redor enquanto se move.

set values[88]=Muk
Tipo: Veneno
Número: 089
Pré: Grimer
Pós: Nenhuma

Descrição:
Muk, o Pokémon Lodo, é ainda mais tóxico que Grimer. Ele libera um cheiro horrível que causa náusea.

set values[89]=Shellder
Tipo: Água
Número: 090
Pré: Nenhuma
Pós: Cloyster

Descrição:
Shellder, o Pokémon Bivalve, se protege com uma concha dura. Ele fecha sua concha com força ao menor sinal de perigo.

set values[90]=Cloyster
Tipo: Água/Gelo
Número: 091
Pré: Shellder
Pós: Nenhuma

Descrição:
Cloyster, o Pokémon Bivalve, possui uma concha quase impenetrável. Ele dispara espinhos para se defender e atacar.

set values[91]=Gastly
Tipo: Fantasma/Veneno
Número: 092
Pré: Nenhuma
Pós: Haunter

Descrição:
Gastly, o Pokémon Gasoso, é composto de gás venenoso. Ele flutua silenciosamente em busca de presas.

set values[92]=Haunter
Tipo: Fantasma/Veneno
Número: 093
Pré: Gastly
Pós: Gengar

Descrição:
Haunter, o Pokémon Gasoso, é assustador e brincalhão. Ele aparece à noite para pregar sustos em viajantes desavisados.

set values[93]=Gengar
Tipo: Fantasma/Veneno
Número: 094
Pré: Haunter
Pós: Nenhuma

Descrição:
Gengar, o Pokémon Sombra, adora causar medo com suas brincadeiras. Ele é capaz de se fundir com as sombras ao seu redor.

set values[94]=Onix
Tipo: Rocha/Terra
Número: 095
Pré: Nenhuma
Pós: Nenhuma

Descrição:
Onix, o Pokémon Serpente de Rocha, é enorme e composto por pedras conectadas. Ele escava túneis profundos para viver.

set values[95]=Drowzee
Tipo: Psíquico
Número: 096
Pré: Nenhuma
Pós: Hypno

Descrição:
Drowzee, o Pokémon Hipnose, induz o sono em seus alvos. Ele prefere comer sonhos agradáveis e evita pesadelos.

set values[96]=Hypno
Tipo: Psíquico
Número: 097
Pré: Drowzee
Pós: Nenhuma

Descrição:
Hypno, o Pokémon Hipnose, usa um pêndulo para hipnotizar suas presas. Ele é misterioso e guarda muitos segredos.

set values[97]=Krabby
Tipo: Água
Número: 098
Pré: Nenhuma
Pós: Kingler

Descrição:
Krabby, o Pokémon Caranguejo, vive em praias e margens de rios. Ele usa suas pinças para se defender e buscar alimentos.

set values[98]=Kingler
Tipo: Água
Número: 099
Pré: Krabby
Pós: Nenhuma

Descrição:
Kingler, o Pokémon Caranguejo, possui uma pinça enorme e poderosa. Ele utiliza sua força para esmagar conchas e pedras.

set values[99]=Voltorb
Tipo: Elétrico
Número: 100
Pré: Nenhuma
Pós: Electrode

Descrição:
Voltorb, o Pokémon Bola, é conhecido por sua semelhança com uma Pokébola. Ele explode ao menor impacto ou provocação.

set values[100]=Electrode
Tipo: Elétrico
Número: 101
Pré: Voltorb
Pós: Nenhuma

Descrição:
Electrode, o Pokémon Bola, é muito mais rápido que Voltorb. Ele adora absorver eletricidade e pode explodir violentamente se sobrecarregado.

set values[101]=Exeggcute
Tipo: Planta/Psíquico
Número: 102
Pré: Nenhuma
Pós: Exeggutor

Descrição:
Exeggcute, o Pokémon Ovo, é composto por seis ovos que compartilham uma mente. Eles se protegem agrupando-se bem próximos.

set values[102]=Exeggutor
Tipo: Planta/Psíquico
Número: 103
Pré: Exeggcute
Pós: Nenhuma

Descrição:
Exeggutor, o Pokémon Coco, é alto e forte. Suas cabeças trabalham juntas para lançar ataques psíquicos devastadores.

set values[103]=Cubone
Tipo: Terra
Número: 104
Pré: Nenhuma
Pós: Marowak

Descrição:
Cubone, o Pokémon Solitário, usa o crânio de sua mãe como capacete. Ele é conhecido por chorar à noite ao lembrar dela.

set values[104]=Marowak
Tipo: Terra
Número: 105
Pré: Cubone
Pós: Nenhuma

Descrição:
Marowak, o Pokémon Guardião, superou sua tristeza e tornou-se um guerreiro valente. Ele utiliza um osso como arma com grande habilidade.

set values[105]=Hitmonlee
Tipo: Lutador
Número: 106
Pré: Tyrogue (não listado em FireRed/LeafGreen)
Pós: Nenhuma

Descrição:
Hitmonlee, o Pokémon Lutador, é especialista em chutes. Suas pernas elásticas permitem ataques rápidos e precisos.

set values[106]=Hitmonchan
Tipo: Lutador
Número: 107
Pré: Tyrogue (não listado em FireRed/LeafGreen)
Pós: Nenhuma

Descrição:
Hitmonchan, o Pokémon Lutador, é mestre em socos. Ele pode usar uma grande variedade de golpes elementares.

set values[107]=Lickitung
Tipo: Normal
Número: 108
Pré: Nenhuma
Pós: Nenhuma

Descrição:
Lickitung, o Pokémon Lambedor, possui uma língua incrivelmente longa e ágil. Ele a usa para explorar objetos e capturar comida.

set values[108]=Koffing
Tipo: Veneno
Número: 109
Pré: Nenhuma
Pós: Weezing

Descrição:
Koffing, o Pokémon Gás, flutua carregando gás venenoso. Ele é frequentemente encontrado em áreas poluídas.

set values[109]=Weezing
Tipo: Veneno
Número: 110
Pré: Koffing
Pós: Nenhuma

Descrição:
Weezing, o Pokémon Gás, é formado por dois Koffing fundidos. Ele emite um cheiro terrível ao liberar gases tóxicos.

set values[110]=Rhyhorn
Tipo: Terra/Rocha
Número: 111
Pré: Nenhuma
Pós: Rhydon

Descrição:
Rhyhorn, o Pokémon Espinhoso, é forte, mas tem dificuldade em fazer curvas enquanto corre. Sua pele grossa o protege de danos.

set values[111]=Rhydon
Tipo: Terra/Rocha
Número: 112
Pré: Rhyhorn
Pós: Nenhuma

Descrição:
Rhydon, o Pokémon Broca, é conhecido por sua força imensa e sua habilidade de suportar calor extremo e ataques poderosos.

set values[112]=Chansey
Tipo: Normal
Número: 113
Pré: Nenhuma
Pós: Blissey (não listado em FireRed/LeafGreen)

Descrição:
Chansey, o Pokémon Sorte, é gentil e adora ajudar os outros. Ele carrega ovos deliciosos e nutritivos.

set values[113]=Tangela
Tipo: Planta
Número: 114
Pré: Nenhuma
Pós: Nenhuma

Descrição:
Tangela, o Pokémon Videira, é coberto por vinhas azuis que crescem continuamente. Ele as utiliza para se proteger e atacar.

set values[114]=Kangaskhan
Tipo: Normal
Número: 115
Pré: Nenhuma
Pós: Nenhuma

Descrição:
Kangaskhan, o Pokémon Paternal, é ferozmente protetor de seu filhote. Ele luta com determinação para manter sua cria segura.

set values[115]=Horsea
Tipo: Água
Número: 116
Pré: Nenhuma
Pós: Seadra

Descrição:
Horsea, o Pokémon Dragão do Mar, nada graciosamente e dispara água em alta pressão para se defender.

set values[116]=Seadra
Tipo: Água
Número: 117
Pré: Horsea
Pós: Nenhuma

Descrição:
Seadra, o Pokémon Dragão do Mar, é ágil e gosta de viver entre corais. Ele é conhecido por sua habilidade de envenenar inimigos com espinhos.

set values[117]=Goldeen
Tipo: Água
Número: 118
Pré: Nenhuma
Pós: Seaking

Descrição:
Goldeen, o Pokémon Dourado, é gracioso e frequentemente comparado a uma dançarina. Ele utiliza seu chifre para se defender.

set values[118]=Seaking
Tipo: Água
Número: 119
Pré: Goldeen
Pós: Nenhuma

Descrição:
Seaking, o Pokémon Dourado, é um nadador poderoso. Ele cria ninhos em rios e lagos durante a temporada de acasalamento.

set values[119]=Staryu
Tipo: Água
Número: 120
Pré: Nenhuma
Pós: Starmie

Descrição:
Staryu, o Pokémon Estrela do Mar, é capaz de regenerar seus membros perdidos. Seu núcleo brilha intensamente durante a noite.

set values[120]=Starmie
Tipo: Água/Psíquico
Número: 121
Pré: Staryu
Pós: Nenhuma

Descrição:
Starmie, o Pokémon Estrela do Mar, emite luzes misteriosas de seu núcleo colorido, que é conhecido como "joia do coração".

set values[121]=Mr. Mime
Tipo: Psíquico/Fada
Número: 122
Pré: Nenhuma
Pós: Nenhuma

Descrição:
Mr. Mime, o Pokémon Barreira, é especialista em criar barreiras invisíveis com movimentos de mímica extremamente precisos.

set values[122]=Scyther
Tipo: Inseto/Voador
Número: 123
Pré: Nenhuma
Pós: Nenhuma (Scizor não listado em FireRed/LeafGreen)

Descrição:
Scyther, o Pokémon Louva-a-Deus, é incrivelmente rápido e usa suas lâminas afiadas para cortar o inimigo com precisão.

set values[123]=Jynx
Tipo: Gelo/Psíquico
Número: 124
Pré: Nenhuma
Pós: Nenhuma

Descrição:
Jynx, o Pokémon Humanoide, é conhecido por seus movimentos de dança rítmica, que hipnotizam e confundem oponentes.

set values[124]=Electabuzz
Tipo: Elétrico
Número: 125
Pré: Nenhuma
Pós: Nenhuma (Electivire não listado em FireRed/LeafGreen)

Descrição:
Electabuzz, o Pokémon Elétrico, atrai raios durante tempestades. Sua pele carrega uma carga elétrica constante.

set values[125]=Magmar
Tipo: Fogo
Número: 126
Pré: Nenhuma
Pós: Nenhuma (Magmortar não listado em FireRed/LeafGreen)

Descrição:
Magmar, o Pokémon Cuspidor de Fogo, vive perto de vulcões. Sua temperatura corporal é tão alta que pode derreter pedras.

set values[126]=Pinsir
Tipo: Inseto
Número: 127
Pré: Nenhuma
Pós: Nenhuma

Descrição:
Pinsir, o Pokémon Besouro, usa suas pinças poderosas para esmagar e levantar inimigos, mostrando uma força surpreendente.

set values[127]=Tauros
Tipo: Normal
Número: 128
Pré: Nenhuma
Pós: Nenhuma

Descrição:
Tauros, o Pokémon Touro Selvagem, é agressivo e adora correr enquanto balança suas três caudas em batalha.

set values[128]=Magikarp
Tipo: Água
Número: 129
Pré: Nenhuma
Pós: Gyarados

Descrição:
Magikarp, o Pokémon Peixe, é conhecido por sua fraqueza, mas também por sua capacidade de superar desafios e evoluir para Gyarados.

set values[129]=Gyarados
Tipo: Água/Voador
Número: 130
Pré: Magikarp
Pós: Nenhuma

Descrição:
Gyarados, o Pokémon Atroz, é feroz e destrutivo. Sua fúria é lendária e o torna temido em batalhas.

set values[130]=Lapras
Tipo: Água/Gelo
Número: 131
Pré: Nenhuma
Pós: Nenhuma

Descrição:
Lapras, o Pokémon Transporte, é gentil e inteligente. Ele adora carregar pessoas e Pokémon pelas águas tranquilas.

set values[131]=Ditto
Tipo: Normal
Número: 132
Pré: Nenhuma
Pós: Nenhuma

Descrição:
Ditto, o Pokémon Transformação, pode se transformar em qualquer Pokémon que vir, copiando habilidades e aparência.

set values[132]=Eevee
Tipo: Normal
Número: 133
Pré: Nenhuma
Pós: Vaporeon, Jolteon, Flareon

Descrição:
Eevee, o Pokémon Evolução, possui um DNA instável que lhe permite evoluir para várias formas diferentes.

set values[133]=Vaporeon
Tipo: Água
Número: 134
Pré: Eevee
Pós: Nenhuma

Descrição:
Vaporeon, o Pokémon Bolhas, é uma evolução aquática de Eevee. Ele pode se misturar na água para se camuflar.

set values[134]=Jolteon
Tipo: Elétrico
Número: 135
Pré: Eevee
Pós: Nenhuma

Descrição:
Jolteon, o Pokémon Relâmpago, é uma evolução elétrica de Eevee. Ele dispara raios de eletricidade ao ser provocado.

set values[135]=Flareon
Tipo: Fogo
Número: 136
Pré: Eevee
Pós: Nenhuma

Descrição:
Flareon, o Pokémon Chama, é uma evolução de fogo de Eevee. Sua temperatura interna pode alcançar níveis extremos.

set values[136]=Porygon
Tipo: Normal
Número: 137
Pré: Nenhuma
Pós: Nenhuma (Porygon2 não listado em FireRed/LeafGreen)

Descrição:
Porygon, o Pokémon Virtual, foi criado artificialmente. Ele pode entrar em sistemas de computadores para explorar dados.

set values[137]=Omanyte
Tipo: Rocha/Água
Número: 138
Pré: Nenhuma
Pós: Omastar

Descrição:
Omanyte, o Pokémon Espiral, é um fóssil trazido à vida. Ele usa seus tentáculos para se mover e capturar presas.

set values[138]=Omastar
Tipo: Rocha/Água
Número: 139
Pré: Omanyte
Pós: Nenhuma

Descrição:
Omastar, o Pokémon Espiral, possui uma mandíbula poderosa que pode esmagar conchas duras. Ele era um predador em tempos antigos.

set values[139]=Kabuto
Tipo: Rocha/Água
Número: 140
Pré: Nenhuma
Pós: Kabutops

Descrição:
Kabuto, o Pokémon Fóssil, foi revivido de um fóssil. Ele é protegido por uma carapaça resistente que o mantém seguro.

set values[140]=Kabutops
Tipo: Rocha/Água
Número: 141
Pré: Kabuto
Pós: Nenhuma

Descrição:
Kabutops, o Pokémon Fóssil, é um predador ágil com lâminas afiadas nas mãos. Ele é um caçador imbatível, tanto na água quanto em terra.

set values[141]=Aerodactyl
Tipo: Rocha/Voador
Número: 142
Pré: Nenhuma
Pós: Nenhuma

Descrição:
Aerodactyl, o Pokémon Fóssil, é um dinossauro voador com asas grandes e afiadas. Ele é conhecido por sua velocidade e habilidades de caça.

set values[142]=Snorlax
Tipo: Normal
Número: 143
Pré: Nenhuma
Pós: Nenhuma

Descrição:
Snorlax, o Pokémon Dorminhoco, é imenso e preguiçoso. Ele passa a maior parte do tempo dormindo, mas é muito forte quando acorda.

set values[143]=Articuno
Tipo: Gelo/Voador
Número: 144
Pré: Nenhuma
Pós: Nenhuma

Descrição:
Articuno, o Pokémon Pássaro da Gelo, é um dos três lendários de Kanto. Ele é capaz de controlar o frio e criar tempestades de neve.

set values[144]=Zapdos
Tipo: Elétrico/Voador
Número: 145
Pré: Nenhuma
Pós: Nenhuma

Descrição:
Zapdos, o Pokémon Pássaro Elétrico, é outro lendário de Kanto. Sua presença causa tempestades elétricas, e seus poderes podem ser devastadores.

set values[145]=Moltres
Tipo: Fogo/Voador
Número: 146
Pré: Nenhuma
Pós: Nenhuma

Descrição:
Moltres, o Pokémon Pássaro de Fogo, é o terceiro dos lendários de Kanto. Ele é capaz de gerar chamas intensas e incandescentes, capazes de derreter tudo em seu caminho.

set values[146]=Dratini
Tipo: Dragão
Número: 147
Pré: Nenhuma
Pós: Dragonair

Descrição:
Dratini, o Pokémon Dragão, é uma criatura mística que vive em águas limpas. Ele é uma das formas mais jovens e raras de Pokémon Dragão.

set values[147]=Dragonair
Tipo: Dragão
Número: 148
Pré: Dratini
Pós: Dragonite

Descrição:
Dragonair, o Pokémon Dragão, é elegante e poderoso. Ele é capaz de controlar os ventos e se proteger de ataques com sua habilidade única.

set values[148]=Dragonite
Tipo: Dragão/Voador
Número: 149
Pré: Dragonair
Pós: Nenhuma

Descrição:
Dragonite, o Pokémon Dragão, é uma evolução de Dragonair e uma das criaturas mais poderosas da região. Ele é amigável e protetor, além de ser um excelente nadador e voador.

set values[149]=Mewtwo
Tipo: Psíquico
Número: 150
Pré: Nenhuma
Pós: Nenhuma

Descrição:
Mewtwo, o Pokémon Geneticamente Modificado, foi criado a partir do DNA de Mew. Ele é extremamente poderoso e pode controlar a mente e o espaço ao seu redor.

set values[150]=Mew
Tipo: Psíquico
Número: 151
Pré: Nenhuma
Pós: Nenhuma

Descrição:
Mew, o Pokémon Misterioso, é uma das criaturas mais raras e enigmáticas. Ele possui habilidades psíquicas impressionantes e pode aprender qualquer movimento, tornando-o extremamente versátil.


rem Loop para percorrer os vetores e criar os arquivos com seus valores
for /L %%i in (0, 1, 150) do (
    rem Criar o arquivo e inserir o valor correspondente
    echo !values[%%i]! > !files[%%i]!
)

rem Mensagem de sucesso
echo Arquivos criados e valores inseridos com sucesso!

pause