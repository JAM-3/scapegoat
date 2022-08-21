package demoMod.scapegoat.cards.scapegoat;

import basemod.abstracts.CustomCard;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import demoMod.scapegoat.Scapegoat;
import demoMod.scapegoat.enums.AbstractCardEnum;
import demoMod.scapegoat.interfaces.BetaArtCard;
import demoMod.scapegoat.powers.BulletPower;

import java.util.function.Supplier;

public class Reloaded extends CustomCard implements BetaArtCard {
    public static final String ID = Scapegoat.makeID("Reloaded");
    public static final String NAME;
    public static final String DESCRIPTION;
    public static final String IMG_PATH = "cards/reloaded.png";
    private static final String BETA_ART_PATH = Scapegoat.getResourcePath("cards/betaArt/reloaded.png");

    private static final CardStrings cardStrings;
    private static final CardType TYPE = CardType.SKILL;
    private static final CardRarity RARITY = CardRarity.COMMON;
    private static final CardTarget TARGET = CardTarget.ENEMY;

    private static final int COST = 1;

    public Reloaded() {
        super(ID, NAME, Scapegoat.getResourcePath(IMG_PATH), COST, DESCRIPTION, TYPE, AbstractCardEnum.SCAPEGOAT, RARITY, TARGET);
        this.baseBlock = 8;
        this.baseMagicNumber = this.magicNumber = 2;
        Scapegoat.loadJokeCardImage(this, BETA_ART_PATH);
    }

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeBlock(3);
        }
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p, this.block));
        addToBot(new ApplyPowerAction(m, p, new BulletPower(m, this.magicNumber)));
    }

    @Override
    public String getCardID() {
        return cardID;
    }

    @Override
    public String getTextureImg() {
        return textureImg;
    }

    @Override
    public String getBetaArtPath() {
        return BETA_ART_PATH;
    }

    @Override
    public Supplier<Texture> getDefaultTexture() {
        return () -> super.getPortraitImage();
    }

    @Override
    public Texture getPortraitImage() {
        return BetaArtCard.super.getPortraitImage();
    }

    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
        NAME = cardStrings.NAME;
        DESCRIPTION = cardStrings.DESCRIPTION;
    }
}
