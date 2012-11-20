package cpw.mods.fml.client;

import java.io.File;
import java.util.Map.Entry;

import cpw.mods.fml.common.DuplicateModsFoundException;
import cpw.mods.fml.common.MissingModsException;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.versioning.ArtifactVersion;
import net.minecraft.client.GuiErrorScreen;

public class GuiDupesFound extends GuiErrorScreen
{

    private DuplicateModsFoundException dupes;

    public GuiDupesFound(DuplicateModsFoundException dupes)
    {
        this.dupes = dupes;
    }

    @Override
    public void func_73866_w_()
    {
        super.func_73866_w_();
    }
    @Override
    public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        this.func_73873_v_();
        int offset = Math.max(85 - dupes.dupes.size() * 10, 10);
        this.func_73732_a(this.field_73886_k, "Forge Mod Loader has found a problem with your minecraft installation", this.field_73880_f / 2, offset, 0xFFFFFF);
        offset+=10;
        this.func_73732_a(this.field_73886_k, "You have mod sources that are duplicate within your system", this.field_73880_f / 2, offset, 0xFFFFFF);
        offset+=10;
        this.func_73732_a(this.field_73886_k, "Mod Id : File name", this.field_73880_f / 2, offset, 0xFFFFFF);
        offset+=5;
        for (Entry<ModContainer, File> mc : dupes.dupes.entries())
        {
            offset+=10;
            this.func_73732_a(this.field_73886_k, String.format("%s : %s", mc.getKey().getModId(), mc.getValue().getName()), this.field_73880_f / 2, offset, 0xEEEEEE);
        }
    }
}
