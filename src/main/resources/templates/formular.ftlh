[#ftl]
[@c.page]
    <div class="detail">
        [@form.form method="post" class="vizitka" bind="vizitka"]
            [@form.input name="celeJmeno" label="Jméno a příjmení*" maxlength="100" required="required"/]
            [@form.input name="firma" label="Firma *" maxlength="100" required="required" /]
            [@form.input name="ulice" label="Ulice a číslo domu*" maxlength="100" required="required" /]
            [@form.input name="obec" label="Obec *" maxlength="100" required="required" /]
            [@form.input name="psc" label="PSČ *" minlength="5" maxlength="5" pattern="[0-9]{5}" required="required" /]
            [@form.input name="email" label="E-mail" maxlength="100" type="email"/]
            [@form.input name="telefon" label="Telefon" maxlength="100" type="tel" /]
            [@form.input name="web" label="Web" maxlength="100" /]
            <div class="form-controls">
                <button type="submit">Odeslat</button>
            </div>
        [/@form.form]

        [@c.back /]
    </div>
[/@c.page]
